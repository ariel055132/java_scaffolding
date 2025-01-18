package com.test.common.validation;

import jakarta.validation.ConstraintViolation;
import lombok.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class EqualsValidationTest extends BaseValidatorTest {

    @Test
    @DisplayName("Test Equals Validation")
    public void testEqualsValidation() {
        EqualsTestClass equalsTestClass = new EqualsTestClass();
        equalsTestClass.setValue1("value1");
        equalsTestClass.setValue2("value2");

        Set<ConstraintViolation<EqualsTestClass>> violation = validator.validate(equalsTestClass);
        System.out.println(violation.toString());
        assertFalse(violation.isEmpty());
    }




    @Data
    @Equals(field = {"value1", "value2"}, message = "value1 must be equal to value2")
    public static class EqualsTestClass {
        private String value1;

        private String value2;
    }

}
