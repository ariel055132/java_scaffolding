package com.test.common.validation;

import jakarta.validation.ConstraintViolation;
import lombok.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class GreaterThanValidationTest extends BaseValidatorTest {
    @Test
    @DisplayName("Test GreaterThan validation - startDate")
    public void testGreaterThanValidation() {
        GreaterThanTestClass greaterThanTestClass = new GreaterThanTestClass();
        greaterThanTestClass.setMinAmonut(BigDecimal.valueOf(100));
        greaterThanTestClass.setMaxAmount(BigDecimal.valueOf(50));

        greaterThanTestClass.setEndDate(LocalDate.of(2021, 1, 1));
        greaterThanTestClass.setStartDate(LocalDate.of(2021, 1, 2));

        Set<ConstraintViolation<GreaterThanTestClass>> violation = validator.validate(greaterThanTestClass);
        System.out.println(violation.toString());
        assertFalse(violation.isEmpty());
    }

    @Data
    @GreaterThan(field = {"startDate", "endDate"}, message = "endDate must be greater than startDate")
    @GreaterThan(field = {"minAmount", "maxAmount"}, message = "maxAmount must be greater than minAmount")
    public static class GreaterThanTestClass {
        private LocalDate startDate;

        private LocalDate endDate;

        private BigDecimal minAmonut;

        private BigDecimal maxAmount;
    }
}
