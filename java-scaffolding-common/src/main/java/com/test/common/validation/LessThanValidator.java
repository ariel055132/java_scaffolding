package com.test.common.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

/**
 * Less Than Annotation Validator
 */


public class LessThanValidator implements ConstraintValidator<LessThan, Object> {

    private LessThan constraintAnnotation;

    private String[] fields;

    @Override
    public void initialize(LessThan constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.constraintAnnotation = constraintAnnotation;
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        // Skip validation for null objects
        if (value == null) {
            return true;
        }

        try {
            // Retrieves the field names to be compared
            String fromField = fields[0];
            String toField = fields[1];

            // Use Reflection to access the fields
            Field from = value.getClass().getDeclaredField(fromField);
            Field to = value.getClass().getDeclaredField(toField);

            // Set the fields to be accessible, (so that private xxx can be accessed)
            from.setAccessible(true);
            to.setAccessible(true);

            // Retrieve the values of the fields
            Object fromValue = from.get(value);
            Object toValue = to.get(value);

            // Checks if the fields are comparable
            if (!(fromValue instanceof Comparable) || !(toValue instanceof Comparable)) {
                return false;
            }

            // Compares the values and adds a constraint violation if the condition is not met
            // If first value is not less than the second value -> constraint violation
            Comparable<Object> fromComparable = (Comparable<Object>) fromValue;
            if (fromComparable.compareTo(toValue) >= 0) {
                constraintValidatorContext.disableDefaultConstraintViolation();
                constraintValidatorContext.buildConstraintViolationWithTemplate(String.format("'%s' must be less than '%s'", fromField, toField))
                        .addPropertyNode(fromField)
                        .addConstraintViolation();
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
