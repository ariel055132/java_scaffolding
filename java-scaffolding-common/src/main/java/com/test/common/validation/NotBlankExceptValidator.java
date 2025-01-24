package com.test.common.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.lang.reflect.Field;

/**
 * Not Blank Annotation Validator
 */

public class NotBlankExceptValidator implements ConstraintValidator<NotBlankExcept, Object> {
    private String field;

    private String condition;

    @Override
    public void initialize(NotBlankExcept constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.condition = constraintAnnotation.condition();
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

            if (targetFieldValue instanceof String && ((String) targetFieldValue).isEmpty()) {
                ExpressionParser parser = new SpelExpressionParser();
                StandardEvaluationContext evaluationContext = new StandardEvaluationContext(value);
                Expression expression = parser.parseExpression(condition);
                Boolean result = expression.getValue(evaluationContext, Boolean.class);
                if (!Boolean.TRUE.equals(result)) {
                    constraintValidatorContext.disableDefaultConstraintViolation();
                    constraintValidatorContext.buildConstraintViolationWithTemplate("field can not be blank")
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
