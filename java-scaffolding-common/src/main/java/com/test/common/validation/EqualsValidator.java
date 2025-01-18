package com.test.common.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * 檢核指定欄位是否相等
 * Check if the specified fields are equal
 */

public class EqualsValidator implements ConstraintValidator<Equals, Object> {

    private Equals constraintAnnotation;

    private String[] fields;

    @Override
    public void initialize(Equals constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.constraintAnnotation = constraintAnnotation;
    }

    @Override
    public boolean isValid(Object values, ConstraintValidatorContext constraintValidatorContext) {
        // Skip validation for null objects
        if (values == null) {
            return true;
        }

        try {
            // Retrieves the field names to be compared
            String fromField = fields[0];
            String toField = fields[1];

            // Retrieve the values of the fields
            Object fromValue = values.getClass().getDeclaredField(fromField).get(values);
            Object toValue = values.getClass().getDeclaredField(toField).get(values);

            // Compares the values and adds a constraint violation if the condition is not met
            if (fromValue == null && toValue == null) {
                return true;
            }
            if (fromValue == null || toValue == null) {
                return false;
            }
            if (!fromValue.equals(toValue)) {
                constraintValidatorContext.disableDefaultConstraintViolation();
                constraintValidatorContext.buildConstraintViolationWithTemplate(String.format("'%s' must be equal to '%s'", fromField, toField))
                        .addPropertyNode(fromField)
                        .addConstraintViolation();
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
