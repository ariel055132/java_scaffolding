package com.test.common.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SensitiveDataProcessUtilsTest {
    @Test
    @DisplayName("處理中文姓名(>2個字元)")
    void testProcessChineseName() {
        // Given
        String chineseName = "王小明";
        // When
        String actualResult = SensitiveDataProcessUtils.processChineseName(chineseName);
        // Then
        Assertions.assertEquals("王*明", actualResult);
    }
}
