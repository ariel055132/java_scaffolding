package com.test.common.validation;

import jakarta.validation.ConstraintViolation;
import lombok.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class NotNullExceptValidationTest extends BaseValidatorTest {
    @Test
    @DisplayName("")
    public void testNotNullExceptValidation() {
        NotNullExceptTestClass notNullExceptTestClass = new NotNullExceptTestClass();
        notNullExceptTestClass.setDueDate(null);
        notNullExceptTestClass.setTerm(null);

        Set<ConstraintViolation<NotNullExceptTestClass>> violation = validator.validate(notNullExceptTestClass);
        System.out.println(violation.toString());
        assertFalse(violation.isEmpty());

    }

    @Data
    @NotBlankExcept(field = "dueDate", condition = "#{term == null}", message = "accountNo and identityNo cannot be null at the same time")
    @NotBlankExcept(field = "term", condition = "#{dueDate == null}", message = "accountNo and identityNo cannot be null at the same time")
    public class NotNullExceptTestClass {
        private LocalDate dueDate;

        private String term;
    }
}
