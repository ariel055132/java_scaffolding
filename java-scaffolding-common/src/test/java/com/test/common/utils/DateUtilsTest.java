package com.test.common.utils;

import com.test.common.constants.DateConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtilsTest {
    @Test
    void testLocalDateToString() {
        // Given
        LocalDate localDate = LocalDate.of(2024, 11, 16);
        // When
        String actualResult = DateUtils.localDateToString(localDate);
        // Then
        Assertions.assertEquals("20241116", actualResult);
    }

    @Test
    void testLocalDateToString1() {
        // Given
        LocalDate localDate = LocalDate.of(2024, 11, 16);
        DateTimeFormatter formatter = DateConstants.YYYY_MM_DD_ISO;
        // When
        String actualResult = DateUtils.localDateToString(localDate, formatter);
        // Then
        Assertions.assertEquals("2024-11-16", actualResult);
    }
}
