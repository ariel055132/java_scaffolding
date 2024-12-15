package com.test.common.utils;

import com.test.common.validation.helper.TaiwanIdValidationHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaiwanIdHelperTest {
    @Test
    public void testIsValidTaiwanId() {
        String id = "A123456789";
        boolean result = TaiwanIdValidationHelper.isValidTaiwanId(id);
        System.out.println(result);
        Assertions.assertEquals(result, true);
    }


}
