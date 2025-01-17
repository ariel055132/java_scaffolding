package com.test.common.validation;

import com.test.common.validation.enums.TaiwanIdType;
import lombok.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaiwanIdValidatorTest extends BaseValidatorTest {

    @Test
    @DisplayName("Test valid Taiwan ID")
    public void testValidTaiwanId() {
        NativeClass testClass = new NativeClass();
        testClass.setId("A123456789");
        var violationSet = validator.validate(testClass);
        System.out.println(violationSet.toString());
        assertTrue(violationSet.isEmpty());
    }

    @Test
    @DisplayName("Test invalid Taiwan ID")
    public void testInvalidTaiwanId() {
        NativeClass testClass = new NativeClass();
        testClass.setId("A12345678");
        var violationSet = validator.validate(testClass);
        System.out.println(violationSet.toString());
        assertFalse(violationSet.isEmpty());
    }

    @Test
    @DisplayName("Test valid Foreigner Taiwan ID")
    public void testValidForeignerTaiwanId() {
        ForeignerClass testClass = new ForeignerClass();
        testClass.setId("FA12345689");
        var violationSet = validator.validate(testClass);
        System.out.println(violationSet.toString());
        assertTrue(violationSet.isEmpty());
    }

    @Test
    @DisplayName("Test valid Company Taiwan ID")
    public void testValidCompanyTaiwanId() {
        companyClass testClass = new companyClass();
        testClass.setId("04595257");
        var violationSet = validator.validate(testClass);
        System.out.println(violationSet.toString());
        assertTrue(violationSet.isEmpty());
    }

    @Data
    private static class NativeClass {
        @TaiwanId(taiwanIdType = TaiwanIdType.NATIVE)
        private String id;

    }

    @Data
    private static class ForeignerClass {
        @TaiwanId(taiwanIdType = TaiwanIdType.FOREIGNER)
        private String id;

    }

    @Data
    private static class companyClass {
        @TaiwanId(taiwanIdType = TaiwanIdType.COMPANY)
        private String id;

    }

}
