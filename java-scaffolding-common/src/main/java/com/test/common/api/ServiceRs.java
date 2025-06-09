package com.test.common.api;

import java.io.Serializable;

/**
 * ServiceRs is a generic class that represents the response structure for service calls.
 * It can be used to encapsulate the result of a service operation, including any data returned and metadata such as status codes or messages.
 * This class is serializable, allowing it to be easily transmitted over a network or stored in a file.
 *
 * @param <T> the type of data contained in the response
 */

public class ServiceRs<T> implements Serializable {
    private static final long serialVersionUID = 6648746575594606251L;

    /**
     * Result Code
     */
    private String code;

    /**
     * Message
     */
    private String message;

    /**
     * Data
     */
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
