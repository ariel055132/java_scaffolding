package com.test.common.validation.enums;

public enum TaiwanIdType {
    NATIVE("{javax.validation.constraints.TAIWAN_ID.message}"),

    FOREIGNER("{javax.validation.constraints.FOREIGNER.message}"),

    COMPANY("{javax.validation.constraints.COMPANY_ID.message}"),
    ;
    String message;

    private TaiwanIdType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
