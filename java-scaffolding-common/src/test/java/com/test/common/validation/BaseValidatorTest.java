package com.test.common.validation;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseValidatorTest {
    public static Validator validator;

    public static ValidatorFactory factory;

    @BeforeEach
    public void setUp() {
        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
}
