package com.test.common.validation.enums;

import com.test.common.validation.TaiwanId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TaiwanIdType {
    // 台灣身分證
    NATIVE(TaiwanId.TAIWAN_ID_MESSAGE),
    // 居留證
    FOREIGNER(TaiwanId.FOREIGNER_MESSAGE),
    // 公司統編
    COMPANY(TaiwanId.COMPANY_MESSAGE),
    ;

    @Getter
    String message;
}
