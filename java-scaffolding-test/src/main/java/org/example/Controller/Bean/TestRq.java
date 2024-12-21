package org.example.Controller.Bean;

import com.test.common.validation.TaiwanId;
import com.test.common.validation.enums.TaiwanIdType;
import lombok.Data;

@Data
public class TestRq {
    @TaiwanId(taiwanIdType = TaiwanIdType.FOREIGNER)
    private String foreignerId;
}
