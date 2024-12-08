package com.test.common.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {TaiwanIdValidator.class})
public @interface TaiwanId {
    String message() default "Invalid Taiwan ID";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
