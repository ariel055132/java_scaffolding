package com.test.common.exception;

import com.test.common.api.ErrorCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BusinessException extends RuntimeException{
    private String code; // 錯誤碼

    /**
     * 使用已知的錯誤碼，建立 Exception
     *
     * @param codeEnum
     */
    public BusinessException(ErrorCode codeEnum) {
        super(codeEnum.getMessage());
        this.code = codeEnum.getCode();
    }

    /**
     * 使用已知的錯誤碼和自定義訊息，建立 Exception
     *
     * @param codeEnum
     * @param message
     */
    public BusinessException(ErrorCode codeEnum, String message) {
        super(message);
        this.code = codeEnum.getCode();
    }
}
