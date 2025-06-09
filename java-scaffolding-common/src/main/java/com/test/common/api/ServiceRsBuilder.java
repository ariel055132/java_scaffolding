package com.test.common.api;

import org.springframework.stereotype.Component;

/**
 * ServiceRsBuilder is a utility class for building ServiceRs responses.
 * It provides methods to create success and error responses with or without content.
 *
 * @param <T> the type of the content in the ServiceRs
 */
@Component
public class ServiceRsBuilder {
    /**
     * Creates a success response with no content.
     *
     * @return
     * @param <T> the type of the content in the ServiceRs
     */
    public static <T> ServiceRs<T> success() {
        ServiceRs<T> serviceRs = new ServiceRs<>();
        serviceRs.setCode(ResultCodeEnum.SUCCESS.getCode());
        serviceRs.setData(null);
        serviceRs.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        return serviceRs;
    }

    /**
     * Creates a success response with the specified content.
     *
     * @param content the content to include in the response
     * @return a ServiceRs object containing the success response
     * @param <T> the type of the content in the ServiceRs
     */
    public static <T> ServiceRs<T> success(T content) {
        ServiceRs<T> serviceRs = new ServiceRs<>();
        serviceRs.setCode(ResultCodeEnum.SUCCESS.getCode());
        serviceRs.setData(content);
        serviceRs.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        return serviceRs;
    }

    /**
     * Creates an error response with no content.
     *
     * @return a ServiceRs object containing the error response
     * @param <T> the type of the content in the ServiceRs
     */
    public static <T> ServiceRs<T> error() {
        ServiceRs<T> serviceRs = new ServiceRs<>();
        serviceRs.setCode(ResultCodeEnum.SYSTEM_ERROR.getCode());
        serviceRs.setData(null);
        serviceRs.setMessage(ResultCodeEnum.SYSTEM_ERROR.getMessage());
        return serviceRs;
    }

    /**
     * Creates an error response with the specified content.
     *
     * @param content
     * @return
     * @param <T>
     */
    public static <T> ServiceRs<T> error(T content) {
        ServiceRs<T> serviceRs = new ServiceRs<>();
        serviceRs.setCode(ResultCodeEnum.SYSTEM_ERROR.getCode());
        serviceRs.setData(content);
        serviceRs.setMessage(ResultCodeEnum.SYSTEM_ERROR.getMessage());
        return serviceRs;
    }

    /**
     * Creates an error response with a custom code and message.
     *
     * @param codeEnum the custom error code
     * @param message the custom error message
     * @return a ServiceRs object containing the error response
     * @param <T> the type of the content in the ServiceRs
     */
    public static <T> ServiceRs<T> error(String codeEnum, String message) {
        ServiceRs<T> serviceRs = new ServiceRs<>();
        serviceRs.setCode(codeEnum);
        serviceRs.setData(null);
        serviceRs.setMessage(message);
        return serviceRs;
    }

    /**
     * Creates an error response with a custom code, message, and content.
     *
     * @param codeEnum the custom error code
     * @param message the custom error message
     * @param content the content to include in the response
     * @return a ServiceRs object containing the error response
     * @param <T> the type of the content in the ServiceRs
     */
    public static <T> ServiceRs<T> error(String codeEnum, String message, T content) {
        ServiceRs<T> serviceRs = new ServiceRs<>();
        serviceRs.setCode(codeEnum);
        serviceRs.setData(content);
        serviceRs.setMessage(message);
        return serviceRs;
    }
}
