package com.test.common.exception;

import com.test.common.enums.CodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BusinessException extends RuntimeException{
    private int code; // 錯誤碼 (Ref. CodeEnum)

    /**
     * 使用已知的錯誤碼，建立 Exception
     *
     * @param codeEnum
     */
    public BusinessException(CodeEnum codeEnum) {
        super(codeEnum.getMsg());
        this.code = codeEnum.getCode();
    }

    /**
     * 使用自定義的錯誤訊息，建立 Exception
     */
    public BusinessException(CodeEnum codeEnum, String message) {
        super(message);
        this.code = codeEnum.getCode();
    }

    public BusinessException(CodeEnum codeEnum, Throwable msg) {
        super(msg);
        this.code = codeEnum.getCode();
    }
}
