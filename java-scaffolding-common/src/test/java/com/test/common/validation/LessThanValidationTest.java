package com.test.common.validation;

import jakarta.validation.ConstraintViolation;
import lombok.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class LessThanValidationTest extends BaseValidatorTest {

    @BeforeEach
    void init() {
        setUp();
    }

    @Test
    @DisplayName("Test LessThan validation - startDate")
    public void testLessThanValidation() {
        LessThanTestClass lessThanTestClass = new LessThanTestClass();
        lessThanTestClass.setStartDate(LocalDate.of(2021, 1, 2));
        lessThanTestClass.setEndDate(LocalDate.of(2021, 1, 1));

        Set<ConstraintViolation<LessThanTestClass>> violation = validator.validate(lessThanTestClass);
        System.out.println(violation.toString());
        assertFalse(violation.isEmpty());
    }



    @Data
    @LessThan(field = {"startDate", "endDate"}, message = "startDate must be less than endDate")
    @LessThan(field = {"minAmount", "maxAmount"}, message = "minAmount must be less than maxAmount")
    private static class LessThanTestClass {
        private LocalDate startDate;

        private LocalDate endDate;
    }
}
