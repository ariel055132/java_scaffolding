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
        notBlankExceptTestClass.setField2("");

        Set<ConstraintViolation<NotBlankExceptTestClass>> violation = validator.validate(notBlankExceptTestClass);
        System.out.println(violation.toString());
        assertFalse(violation.isEmpty());
    }

    @Data
    @NotBlankExcept(field = "field1", condition = "field1 != null && (field2 == null || field2.isEmpty())", message = "field2 can be blank if field1 is filled")
    public class NotBlankExceptTestClass {
        private String field1;

        private String field2;
    }
}
