package com.test.common.exception;

import com.test.common.bean.Result;
import com.test.common.enums.CodeEnum;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * 全局異常處理
 */

@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 異常處理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Result exceptionHandler(Exception e) {
        return Result.errorResult(CodeEnum.SYSTEM_ERROR.getCode(), e.getMessage());
    }

    /**
     * 參數驗證異常 (POST)
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final Result methodArgumentNotValidHandler(MethodArgumentNotValidException e) {
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        return Result.errorResult(CodeEnum.SYSTEM_ERROR.getCode(), getValidExceptionMsg(allErrors));
    }


    private String getValidExceptionMsg(List<ObjectError> errors) {
        if (!CollectionUtils.isEmpty(errors)) {
            StringBuilder sb = new StringBuilder();
            errors.forEach(error -> {
                if (error instanceof FieldError) {
                    sb.append(((FieldError) error).getField()).append(":");
                }
                sb.append(error.getDefaultMessage()).append(";");
            });
            String msg = sb.toString();
            msg = msg.substring(0, msg.length() - 1);
            return msg;
        }
        return null;
    }
}
