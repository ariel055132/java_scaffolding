package com.test.common.exception;

import com.test.common.bean.Result;
import com.test.common.enums.CodeEnum;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @Autowired
    private HttpServletRequest httpServletRequest;

    /**
     * 異常處理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Result exceptionHandler(Exception e) {
        String requestUrl = httpServletRequest.getRequestURI();
        log.error("Request URL'{}', Catch System Exception'{}'", requestUrl, e);
        return Result.errorResult(CodeEnum.SYSTEM_ERROR.getCode(), e.getMessage());
    }

    /**
     * 使用POST發Request時，參數驗證異常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final Result methodArgumentNotValidHandler(MethodArgumentNotValidException e) {
        String requestUrl = httpServletRequest.getRequestURI();
        log.error("Request URL'{}', Catch MethodArgumentNotValidException'{}'", requestUrl, e.getMessage());
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
