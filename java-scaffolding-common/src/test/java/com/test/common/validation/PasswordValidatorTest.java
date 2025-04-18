package com.test.common.validation;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordValidatorTest extends BaseValidatorTest {

    @Test
    public void testValidPassword() {
        TestClass testClass = new TestClass("Password123");
        Set<ConstraintViolation<TestClass>> violationSet = validator.validate(testClass);
        System.out.println(violationSet.toString());
        assertTrue(violationSet.isEmpty());
    }

    @Test
    public void testInvalidPassword() {
        TestClass testClass = new TestClass("password");
        Set<ConstraintViolation<TestClass>> violation = validator.validate(testClass);
        System.out.println(violation.toString());
        assertFalse(violation.isEmpty());
    }

    private static class TestClass {
        @PasswordRule(upperLetter = 1, lowerLetter = 1, number = 1, nonAlphaNum = 0)
        private final String password;

        public TestClass(String password) {
            this.password = password;
        }
    }
}
