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

    @Test
    void testEquals() {
        // Given
        String cs1 = "Hello World";
        String cs2 = "Hello World";
        // When
        boolean actualResult = StringUtils.equals(cs1, cs2);
        // Then
        Assertions.assertTrue(actualResult);
    }

    @Test
    void testEqualsWithNull() {
        // Given
        String cs1 = "Hello World";
        String cs2 = null;
        // When
        boolean actualResult = StringUtils.equals(cs1, cs2);
        // Then
        Assertions.assertFalse(actualResult);
    }

    @Test
    void testEqualsIgnoreCase() {
        // Given
        String cs1 = "Hello World";
        String cs2 = "hello world";
        // When
        boolean actualResult = StringUtils.equalsIgnoreCase(cs1, cs2);
        // Then
        Assertions.assertTrue(actualResult);
    }

    @Test
    void testIsEmpty() {
        // Given
        String cs = "";
        // When
        boolean actualResult = StringUtils.isEmpty(cs);
        // Then
        Assertions.assertTrue(actualResult);
    }

    @Test
    void testIsEmptyWithNull() {
        // Given
        String cs = null;
        // When
        boolean actualResult = StringUtils.isEmpty(cs);
        // Then
        Assertions.assertTrue(actualResult);
    }

    @Test
    void testIsEmptyWithNonEmptyString() {
        // Given
        String cs = "Hello World";
        // When
        boolean actualResult = StringUtils.isEmpty(cs);
        // Then
        Assertions.assertFalse(actualResult);
    }

}
