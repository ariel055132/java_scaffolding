package com.test.common.utils;

import com.test.common.constants.DateConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtilsTest {
    @Test
    @DisplayName("Test convert LocalDate to String with no formatter")
    void testLocalDateToString() {
        // Given
        LocalDate localDate = LocalDate.of(2024, 11, 16);
        // When
        String actualResult = DateUtils.localDateToString(localDate);
        // Then
        Assertions.assertEquals("20241116", actualResult);
    }

    @Test
    @DisplayName("Test convert LocalDate to String with formatter")
    void testLocalDateToString1() {
        // Given
        LocalDate localDate = LocalDate.of(2024, 11, 16);
        DateTimeFormatter formatter = DateConstants.YYYY_MM_DD_ISO;
        // When
        String actualResult = DateUtils.localDateToString(localDate, formatter);
        // Then
        Assertions.assertEquals("2024-11-16", actualResult);
    }

    @Test
    @DisplayName("Test convert LocalDateTime to String with no formatter")
    void testLocalDateTimeToString() {
        // Given
        LocalDateTime localDateTime = LocalDateTime.of(2024, 11, 16, 12, 30, 45);
        // When
        String actualResult = DateUtils.localDateTimeToString(localDateTime);
        // Then
        Assertions.assertEquals("2024-11-16 12:30:45", actualResult);
    }

    @Test
    @DisplayName("Test convert LocalDateTime to String with formatter")
    void testLocalDateTimeToString1() {
        // Given
        LocalDateTime localDateTime = LocalDateTime.of(2024, 11, 16, 12, 30, 45);
        DateTimeFormatter formatter = DateConstants.YYYY_MM_DD_HH_MM_SS;
        // When
        String actualResult = DateUtils.localDateTimeToString(localDateTime, formatter);
        // Then
        Assertions.assertEquals("2024-11-16 12:30:45", actualResult);
    }

    @Test
    @DisplayName("Test convert String to LocalDate with formatter")
    void testStringToLocalDate() {
        // Given
        String date = "2024-11-16";
        DateTimeFormatter formatter = DateConstants.YYYY_MM_DD_ISO;
        // When
        LocalDate actualResult = DateUtils.stringToLocalDate(date, formatter);
        // Then
        Assertions.assertEquals(LocalDate.of(2024, 11, 16), actualResult);
        Assertions.assertEquals(actualResult.getYear(), 2024);
        Assertions.assertEquals(actualResult.getMonthValue(), 11);
        System.out.println(actualResult.getMonth());
        Assertions.assertEquals(actualResult.getDayOfMonth(), 16);
        System.out.println(actualResult.getDayOfWeek());
    }

    @Test
    @DisplayName("Test String To LocalDate with formatter")
    void testStringToLocalDate1() {
        // Given
        String date = "2024-11-16";
        String datePattern = "yyyy-MM-dd";
        // When
        LocalDate actualResult = DateUtils.stringToLocalDate(date, datePattern);
        // Then
        Assertions.assertEquals(LocalDate.of(2024, 11, 16), actualResult);
        Assertions.assertEquals(actualResult.getYear(), 2024);
        Assertions.assertEquals(actualResult.getMonthValue(), 11);
        System.out.println(actualResult.getMonth());
        Assertions.assertEquals(actualResult.getDayOfMonth(), 16);
        System.out.println(actualResult.getDayOfWeek());
    }
}
