package com.test.common.exception;

import com.test.common.api.ResultCodeEnum;
import com.test.common.api.ServiceRs;
import com.test.common.api.ServiceRsBuilder;
import com.test.common.utils.LogUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * 全局異常處理
 * 1. 確保統一的異常返回格式，減少code的重複量 + 提高可讀性
 * 2. 確保異常的日誌記錄，方便後續的問題追蹤
 * 3. 確保異常的統一處理，避免異常的傳遞，確保服務的穩定性（不會因為某個異常導致整個服務的異常）
 * 4. 自定義錯誤介面，提高用戶體驗
 */

@RestControllerAdvice
public class GlobalExceptionHandler {
    @Autowired
    private HttpServletRequest httpServletRequest;

    /**
     * 異常處理
     *
     * @param e Exception
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ServiceRs exceptionHandler(Exception e) {
        String requestUrl = httpServletRequest.getRequestURI();
        LogUtils.error("Request URL'{}', Catch System Exception'{}'", requestUrl, e);
        return ServiceRsBuilder.error(ResultCodeEnum.SYSTEM_ERROR.getCode(), e.getMessage());
    }

    /**
     * 使用POST發Request時，參數驗證異常
     *
     * @param e MethodArgumentNotValidException
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public final ServiceRs methodArgumentNotValidHandler(MethodArgumentNotValidException e) {
        String requestUrl = httpServletRequest.getRequestURI();
        LogUtils.error("Request URL'{}', Catch MethodArgumentNotValidException with POST '{}'", requestUrl, e.getMessage());
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        return ServiceRsBuilder.error(ResultCodeEnum.SYSTEM_ERROR.getCode(), getValidExceptionMsg(allErrors));
    }

    /**
     * 使用錯的方法進行 calling，例如：POST的method使用了GET
     *
     * @param e HttpRequestMethodNotSupportedException
     * @return
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(value = {HttpRequestMethodNotSupportedException.class})
    public final ServiceRs methodNotAllowedHandler(HttpRequestMethodNotSupportedException e) {
        String requestUrl = httpServletRequest.getRequestURI();
        LogUtils.error("Request URL'{}', Catch HttpRequestMethodNotSupportedException'{}'", requestUrl, e.getMessage());
        return ServiceRsBuilder.error(ResultCodeEnum.SYSTEM_ERROR.getCode(), e.getMessage());
    }

    /**
     * GET Request時，缺少必要的參數
     *
     * @param e MissingServletRequestParameterException
     * @return Result
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {MissingServletRequestParameterException.class})
    public final ServiceRs missingServletRequestParameterHandler(MissingServletRequestParameterException e) {
        String requestUrl = httpServletRequest.getRequestURI();
        LogUtils.error("Request URL'{}', Catch MissingServletRequestParameterException'{}'", requestUrl, e.getMessage());
        return ServiceRsBuilder.error(ResultCodeEnum.SYSTEM_ERROR.getCode(), e.getMessage());
    }

    /**
     * 業務異常
     *
     * @param e BusinessException
     * @return Result
     */
    @ExceptionHandler(value = {BusinessException.class})
    public final ServiceRs businessExceptionHandler(BusinessException e) {
        String requestUrl = httpServletRequest.getRequestURI();
        LogUtils.error("Request URL'{}', Catch BusinessException'{}'", requestUrl, e.getMessage());
        return ServiceRsBuilder.error(ResultCodeEnum.SYSTEM_ERROR.getCode(), e.getMessage());
    }

    /**
     * 運行時錯誤
     *
     * @param e RuntimeException
     * @return
     */
    @ExceptionHandler(value = {RuntimeException.class})
    public final ServiceRs runtimeExceptionHandler(RuntimeException e) {
        String requestUrl = httpServletRequest.getRequestURI();
        LogUtils.error("Request URL'{}', Catch RuntimeException'{}'", requestUrl, e.getMessage());
        return ServiceRsBuilder.error(ResultCodeEnum.SYSTEM_ERROR.getCode(), e.getMessage());
    }

    /**
     * 系統級別異常
     * (所有以上的錯誤均無法包含均會進入此處理)
     * @param e Throwable errors
     * @return Result
     */
    @ExceptionHandler(value = {Throwable.class})
    public final ServiceRs throwableExceptionHandler(Throwable e) {
        String requestUrl = httpServletRequest.getRequestURI();
        LogUtils.error("Request URL'{}', Catch Throwable'{}'", requestUrl, e.getMessage());
        return ServiceRsBuilder.error(ResultCodeEnum.SYSTEM_ERROR.getCode(), e.getMessage());
    }

    /**
     * 獲取參數驗證異常的錯誤訊息
     *
     * @param errors List<ObjectError> 參數驗證錯誤列表
     * @return String
     */
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
