package com.test.common.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

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
            String fromField = fields[0];
            String toField = fields[1];

            Field from = value.getClass().getDeclaredField(fromField);
            Field to = value.getClass().getDeclaredField(toField);

            from.setAccessible(true);
            to.setAccessible(true);

            Object fromValue = from.get(value);
            Object toValue = to.get(value);

            if (!(fromValue instanceof Comparable) || !(toValue instanceof Comparable)) {
                return false;
            }

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
