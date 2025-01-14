package com.test.common.validation;

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

    @Test
    @DisplayName("舊式外國人居留證號測試")
    public void testIsValidOldForeignerTaiwanId() {
        String id = "FA12345689";
        boolean result = TaiwanIdValidationHelper.isOldForeignerTaiwanId(id);
        System.out.println(result);
        Assertions.assertEquals(result, true);
    }

    @Test
    @DisplayName("舊式外國人居留證號測試")
    public void testIsValidOldForeignerTaiwanId2() {
        String id = "F112345678";
        boolean result = TaiwanIdValidationHelper.isOldForeignerTaiwanId(id);
        System.out.println(result);
        Assertions.assertEquals(result, false);
    }

    @Test
    @DisplayName("新式外國人居留證號測試")
    public void testIsValidNewForeignerTaiwanId() {
        String id = "A123456789";
        boolean result = TaiwanIdValidationHelper.isNewForeignerTaiwanId(id);
        System.out.println(result);
        Assertions.assertEquals(result, true);
    }

    @Test
    @DisplayName("外國人居留證號測試")
    public void testValidForeignerTaiwanId() {
        String id = "FA12345689";
        boolean result = TaiwanIdValidationHelper.isValidForeignerTaiwanId(id);
        System.out.println(result);
        Assertions.assertEquals(true, result);
    }
}
