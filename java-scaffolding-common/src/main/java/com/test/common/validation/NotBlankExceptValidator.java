package com.test.common.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Field;

/**
 * Not Blank Except Annotation Validator
 * For dealing situation that some field should not be blank except some condition
 * Especially for String field
 */

public class NotBlankExceptValidator implements ConstraintValidator<NotBlankExcept, Object> {
    private String field;

    private String condition;

    private String message;

    @Override
    public void initialize(NotBlankExcept constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.condition = constraintAnnotation.condition();
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return true;
        }

        try {
            Field targetField = value.getClass().getDeclaredField(field);
            targetField.setAccessible(true);
            Object targetFieldValue = targetField.get(value);

            //if (targetFieldValue instanceof String && ((String) targetFieldValue).isEmpty()) {
            if (ObjectUtils.isEmpty(targetFieldValue)) {
                ExpressionParser parser = new SpelExpressionParser();
                StandardEvaluationContext evaluationContext = new StandardEvaluationContext(value);
                Expression expression = parser.parseExpression(condition);
                Boolean result = expression.getValue(evaluationContext, Boolean.class);
                if (Boolean.FALSE.equals(result)) {
                    constraintValidatorContext.disableDefaultConstraintViolation();
                    constraintValidatorContext.buildConstraintViolationWithTemplate(this.message)
                            .addPropertyNode(field)
                            .addConstraintViolation();
                    return true;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
