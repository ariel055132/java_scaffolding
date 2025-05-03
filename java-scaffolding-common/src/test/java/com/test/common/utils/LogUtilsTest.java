package com.test.common.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LogUtilsTest {
    @Test
    @DisplayName("")
    void logInfo() {
        // Given
        LogUtils.info("Test info level logging");
        LogUtils.info("Test info level logging with parameters: {}, {}", "param1", "param2");
    }
}
