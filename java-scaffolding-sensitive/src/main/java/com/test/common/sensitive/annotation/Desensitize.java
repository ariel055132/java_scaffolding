package com.test.common.sensitive.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.test.common.sensitive.enums.DesensitizeType;
import com.test.common.sensitive.config.DesensitizeSerializer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside
@JsonSerialize(using = DesensitizeSerializer.class)
public @interface Desensitize {
    /**
     * 脱敏类型
     */
    DesensitizeType type() default DesensitizeType.CHINESE_NAME;

    /**
     * 開始位置
     */
    int startIndex() default 0;

    /**
     * 結束位置
     */
    int endIndex() default 0;
}
