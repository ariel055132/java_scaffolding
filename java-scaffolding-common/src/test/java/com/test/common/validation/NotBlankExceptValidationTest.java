package com.test.common.validation;


import jakarta.validation.ConstraintViolation;
import lombok.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class NotBlankExceptValidationTest extends BaseValidatorTest {
    @Test
    @DisplayName("")
    public void testNotBlankExceptValidation() {
        NotBlankExceptTestClass notBlankExceptTestClass = new NotBlankExceptTestClass();
        notBlankExceptTestClass.setField1("");
        notBlankExceptTestClass.setField2(null);

        Set<ConstraintViolation<NotBlankExceptTestClass>> violation = validator.validate(notBlankExceptTestClass);
        System.out.println(violation.toString());
        assertFalse(violation.isEmpty());

        notBlankExceptTestClass.setField1(null);
        notBlankExceptTestClass.setField2("");
        violation = validator.validate(notBlankExceptTestClass);
        System.out.println(violation.toString());
        assertFalse(violation.isEmpty());
    }

    @Data
    @NotBlankExcept(field = "field1", condition = "#{field2 != null}", message = "field1 and field2 cannot be blank at the same time")
    @NotBlankExcept(field = "field2", condition = "#{field1 != null}", message = "field1 and field2 cannot be blank at the same time")
    public class NotBlankExceptTestClass {
        private String field1;

        private String field2;
    }
}
