package com.test.common.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {PasswordValidator.class})
public @interface PasswordRule {
    int upperLetter() default 1;
    int lowerLetter() default 1;
    int number() default 1;
    int nonAlphaNum() default 0;

    //String message() default "{javax.validation.constraints.NotNull.message}";
    String message() default "密碼格式不符";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
