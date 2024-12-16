package com.test.common.validation;

import com.test.common.validation.helper.TaiwanIdValidationHelper;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TaiwanIdValidator implements ConstraintValidator<TaiwanId, String> {
    private TaiwanId constraintAnnotation;

    @Override
    public void initialize(TaiwanId constraintAnnotation) {
        this.constraintAnnotation = constraintAnnotation;
    }

    @Override
    public boolean isValid(String id, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = this.isValidTaiwanId(id);
        if (!result) {
            this.buildMessage(constraintValidatorContext);
        }
        return result;
    }

    private void buildMessage(ConstraintValidatorContext constraintValidatorContext) {
        if (TaiwanId.TAIWAN_ID_MESSAGE.equals(constraintAnnotation.message())) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(constraintAnnotation.taiwanIdType().getMessage())
                    .addConstraintViolation();
        }
    }

    private boolean isValidTaiwanId(String id) {
        switch(constraintAnnotation.taiwanIdType()) {
            case NATIVE:
                return TaiwanIdValidationHelper.isValidTaiwanId(id);
            case FOREIGNER:
                return TaiwanIdValidationHelper.isValidForeignerTaiwanId(id);
            case COMPANY:
                return TaiwanIdValidationHelper.isValidTaiwanCompanyId(id);
            default:
                break;
        }
        return true;
    }
}
