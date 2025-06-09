package com.test.common.api;

/**
 * ResultCodeEnum is an enumeration that defines various result codes and their corresponding messages for use in service responses.
 *
 * 常見的結果代碼枚舉類型，實現了 ErrorCode 接口
 */

public enum ResultCodeEnum implements ErrorCode {
    /**
     * SUCCESS (操作成功)
     */
    SUCCESS("200", "Success"),

    /**
     * SYSTEM_ERROR (系統錯誤)
     */
    SYSTEM_ERROR("500", "System Error"),

    /**
     * VALIDATION_ERROR (驗證失敗)
     */
    VALIDATION_ERROR("400", "Validation Error"),

    /**
     * FORBIDDEN (禁止操作)
     */
    FORBIDDEN("403", "Forbidden");

    /**
     * Result Code
     */
    private String code;

    /**
     * Message Content
     */
    private String message;

    /**
     * Constructor
     */
    ResultCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * Get Result Code
     * @return String
     */
    @Override
    public String getCode() {
        return null;
    }

    @Override
    public String getMessage() {
        return null;
    }
}
