package org.example.service.user.enums;

import com.test.common.api.ErrorCode;

public enum UserServiceEnum implements ErrorCode {
    USER_EXISTS("USER_1001", "Username already exists"),

    USER_NOT_EXISTS("USER_1002", "Username not exists")
    ;
    UserServiceEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * Result Code
     */
    public String code;

    /**
     * Message Content
     */
    public String message;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
