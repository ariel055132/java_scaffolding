package com.test.common.utils;

import com.test.common.validation.TaiwanId;
import com.test.common.validation.enums.TaiwanIdType;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaiwanIdValidatorTest {
    private static Validator validator;

    @BeforeAll
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    @DisplayName("Test valid Taiwan ID")
    public void testValidTaiwanId() {
        NativeClass testClass = new NativeClass("A123456789", TaiwanIdType.NATIVE);
        var violationSet = validator.validate(testClass);
        System.out.println(violationSet.toString());
        assertTrue(violationSet.isEmpty());
    }

    @Test
    @DisplayName("Test invalid Taiwan ID")
    public void testInvalidTaiwanId() {
        NativeClass testClass = new NativeClass("A12345678", TaiwanIdType.NATIVE);
        var violationSet = validator.validate(testClass);
        System.out.println(violationSet.toString());
        assertFalse(violationSet.isEmpty());
    }

    @Test
    @DisplayName("Test valid Foreigner Taiwan ID")
    public void testValidForeignerTaiwanId() {
        ForeignerClass testClass = new ForeignerClass("FA12345689", TaiwanIdType.FOREIGNER);
        var violationSet = validator.validate(testClass);
        System.out.println(violationSet.toString());
        assertTrue(violationSet.isEmpty());
    }

    @Test
    @DisplayName("Test valid Company Taiwan ID")
    public void testValidCompanyTaiwanId() {
        companyClass testClass = new companyClass("04595257", TaiwanIdType.COMPANY);
        var violationSet = validator.validate(testClass);
        System.out.println(violationSet.toString());
        assertTrue(violationSet.isEmpty());
    }

    private static class NativeClass {
        @TaiwanId(taiwanIdType = TaiwanIdType.NATIVE)
        private final String id;

        public NativeClass(String id, TaiwanIdType type) {
            this.id = id;
            this.setTaiwanIdType(type);
        }

        private void setTaiwanIdType(TaiwanIdType type) {

        }
    }

    private static class ForeignerClass {
        @TaiwanId(taiwanIdType = TaiwanIdType.FOREIGNER)
        private final String id;

        public ForeignerClass(String id, TaiwanIdType type) {
            this.id = id;
            this.setTaiwanIdType(type);
        }

        private void setTaiwanIdType(TaiwanIdType type) {

        }
    }

    private static class companyClass {
        @TaiwanId(taiwanIdType = TaiwanIdType.COMPANY)
        private final String id;

        public companyClass(String id, TaiwanIdType type) {
            this.id = id;
            this.setTaiwanIdType(type);
        }

        private void setTaiwanIdType(TaiwanIdType type) {

        }
    }
}
