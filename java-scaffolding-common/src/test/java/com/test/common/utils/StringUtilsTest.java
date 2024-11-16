package com.test.common.utils;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    @Test
    void testContains() {
        // Given
        String str = "Hello World";
        String searchStr = "World";
        // When
        boolean actualResult = StringUtils.contains(str, searchStr);
        // Then
        Assertions.assertTrue(actualResult);
    }

    @Test
    void testContainsIgnoreCase() {
        // Given
        String str = "Hello World";
        String searchStr = "world";
        // When
        boolean actualResult = StringUtils.containsIgnoreCase(str, searchStr);
        // Then
        Assertions.assertTrue(actualResult);
    }

}
