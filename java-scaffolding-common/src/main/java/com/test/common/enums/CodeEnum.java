package com.test.common.enums;

/**
 * 錯誤碼枚舉
 */

public enum CodeEnum {
    SUCCESS(200, "Success"),

    SYSTEM_ERROR(500, "System Error"),;

    private final int code;

    private final String msg;

    CodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }
}
