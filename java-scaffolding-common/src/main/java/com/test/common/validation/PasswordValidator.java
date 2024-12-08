package com.test.common.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordRule, String> {
    private PasswordRule passwordRule;

    @Override
    public void initialize(PasswordRule constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.passwordRule = constraintAnnotation;
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        int numberCount = 0;
        int lowerLetterCount = 0;
        int upperLetterCount = 0;
        int nonAlphaNumCount = 0;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isDigit(ch)) {
                numberCount++;
            } else if (Character.isLowerCase(ch)) {
                lowerLetterCount++;
            } else if (Character.isUpperCase(ch)) {
                upperLetterCount++;
            } else {
                nonAlphaNumCount++;
            }
        }

        boolean result = this.isValidPassword(password, numberCount, lowerLetterCount, upperLetterCount, nonAlphaNumCount);
        if (!result) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(passwordRule.message()).addConstraintViolation();
        }
        return result;
    }

    private boolean isValidPassword(String password, int numberCount, int lowerLetterCount, int upperLetterCount, int nonAlphaNumCount) {
        return password != null &&
                numberCount >= passwordRule.number() &&
                lowerLetterCount >= passwordRule.lowerLetter() &&
                upperLetterCount >= passwordRule.upperLetter() &&
                nonAlphaNumCount >= passwordRule.nonAlphaNum();

    }
}
