package com.test.common.validation;

import com.test.common.validation.enums.TaiwanIdType;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {TaiwanIdValidator.class})
public @interface TaiwanId {
    String TAIWAN_ID_MESSAGE = "{javax.validation.constraints.TAIWAN_ID.message}";

    String FOREIGNER_MESSAGE = "{javax.validation.constraints.FOREIGNER_ID.message}";

    String COMPANY_MESSAGE = "{javax.validation.constraints.COMPANY_ID.message}";

    String message() default "{javax.validation.constraints.TAIWAN_ID.message}";

    TaiwanIdType taiwanIdType() default TaiwanIdType.NATIVE;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
