package com.test.common.utils;

import com.test.common.validation.helper.TaiwanIdValidationHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TaiwanIdValidationHelperTest {
    @Test
    public void testIsValidTaiwanId() {
        String id = "A123456789";
        boolean result = TaiwanIdValidationHelper.isValidTaiwanId(id);
        System.out.println(result);
        Assertions.assertEquals(result, true);
    }

    @Test
    public void testIsValidTaiwanId2() {
        String id = "C201987958";
        boolean result = TaiwanIdValidationHelper.isValidTaiwanId(id);
        System.out.println(result);
        Assertions.assertEquals(result, true);
    }

    @Test
    @DisplayName("統一編號邏輯檢查-統一編號第7位數非7")
    public void testIsValidTaiwanCompanyId() {
        String id = "04595257";
        boolean result = TaiwanIdValidationHelper.isValidTaiwanCompanyId(id);
        System.out.println(result);
        Assertions.assertEquals(result, true);
    }

    @Test
    @DisplayName("統一編號邏輯檢查-統一編號第7位數為7")
    public void testIsValidTaiwanCompanyId2() {
        String id = "10458575";
        boolean result = TaiwanIdValidationHelper.isValidTaiwanCompanyId(id);
        System.out.println(result);
        Assertions.assertEquals(result, true);
    }

    @Test
    @DisplayName("統一編號邏輯檢查-統一編號第7位數為7")
    public void testIsValidTaiwanCompanyId3() {
        String id = "10458574";
        boolean result = TaiwanIdValidationHelper.isValidTaiwanCompanyId(id);
        System.out.println(result);
        Assertions.assertEquals(result, true);
    }
}
