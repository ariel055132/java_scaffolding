package com.test.common.utils;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    @Test
    @DisplayName("Test Contains (Positive Test Case)")
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
    @DisplayName("Test Contains with ignoring case (Positive Test Case)")
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
    @DisplayName("Test Equals (Positive Test Case)")
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
    @DisplayName("Test Equals with null case (Negative Test Case)")
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
    @DisplayName("Test Equals with ignoring case (Positive Test Case)")
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
    @DisplayName("Test isEmpty with SPACE (Positive Test Case)")
    void testIsEmpty() {
        // Given
        String cs = "";
        // When
        boolean actualResult = StringUtils.isEmpty(cs);
        // Then
        Assertions.assertTrue(actualResult);
    }

    @Test
    @DisplayName("Test isEmpty with null (Positive Test Case)")
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

    @Test
    @DisplayName("Test getRepeatCount")
    void testGetRepeatCount() {
        // Given
        String str = "Hello World, Hello World";
        String repeat = "Hello";
        // When
        int actualResult = StringUtils.getRepeatCount(str, repeat);
        // Then
        Assertions.assertEquals(2, actualResult);
    }

    @Test
    @DisplayName("Test Substring with beginIndex only")
    void testSubString() {
        // Given
        String str = "Hello World";
        int beginIndex = 6;
        // When
        String actualResult = StringUtils.substring(str, beginIndex);
        // Then
        Assertions.assertEquals("World", actualResult);
    }

    @Test
    @DisplayName("Test leftPad")
    void testLeftPad() {
        // Given
        String str = "Hello";
        int size = 10;
        char padChar = '@';
        // When
        String actualResult = StringUtils.leftPad(str, size, padChar);
        // Then
        Assertions.assertEquals("@@@@@Hello", actualResult);
    }

    @Test
    @DisplayName("Test rightPad")
    void testRightPad() {
        // Given
        String str = "Hello";
        int size = 10;
        char padChar = '@';
        // When
        String actualResult = StringUtils.rightPad(str, size, padChar);
        // Then
        Assertions.assertEquals("Hello@@@@@", actualResult);
    }

}
