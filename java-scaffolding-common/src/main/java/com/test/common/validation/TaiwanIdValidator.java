package com.test.common.validation;

import com.test.common.validation.helper.TaiwanIdValidationHelper;
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
    public boolean isValid(String id, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValidTaiwanId = this.isValidTaiwanId(id);
        return false;
    }

    private boolean isValidTaiwanId(String id) {
        switch(this.taiwanId.taiwanIdType()) {
            case NATIVE:
                return TaiwanIdValidationHelper.isValidNativeTaiwanId(id);
            case FOREIGNER:
                return TaiwanIdValidationHelper.isValidForeignerTaiwanId(id);
            case COMPANY:
                return TaiwanIdValidationHelper.isValidCompanyTaiwanId(id);
            default:
                return true;
        }
    }
}
