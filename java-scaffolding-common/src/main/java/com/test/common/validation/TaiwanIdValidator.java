package com.test.common.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TaiwanIdValidator implements ConstraintValidator<TaiwanId, String> {
    private TaiwanId taiwanId;

    @Override
    public void initialize(TaiwanId constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.taiwanId = constraintAnnotation;
    }

    @Override
    public boolean isValid(String values, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
