package com.test.common.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * 檢核指定欄位是否相等
 * Check if the specified fields are equal
 */

@Documented
@Constraint(validatedBy = {EqualsValidator.class})
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Equals.List.class)
public @interface Equals {

    String message() default "Equals";

    String[] field();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Documented
    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface List {
        Equals[] value();
    }
}
