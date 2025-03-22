package com.test.common.codec;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Base32UtilsTest {
    @Test
    @DisplayName("Test encodeBase32 (Encoding: UTF-8)")
    void testEncodeBase32() {
        // Given
        String input = "伦家是一个非常长的字符串";
        String expectedResult = "4S6KNZNOW3TJRL7EXCAOJOFK5GOZ5ZNYXDUZLP7HTKCOLLMX46WKNZFYWI======";
        // When
        String actualResult = Base32Utils.encodeToString(input, null);
        // Then
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
