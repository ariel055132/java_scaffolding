package com.test.common.utils;

import com.test.common.constants.DateConstants;
import org.apache.commons.lang3.ObjectUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.MinguoChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

/**
 * Date 日期時間共用函式
 *
 * @author Adrian
 * @date 2024/11/16
 */

public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

    /**
     * Convert LocalDate to String by given formatter
     *
     * @param localDate LocalDate (yyyy-MM-dd)
     * @return String
     */
    public static String localDateToString(LocalDate localDate) {
        return ObjectUtils.isNotEmpty(localDate) ? localDate.format(DateConstants.YYYY_MM_DD_NOSPLIT) : StringUtils.EMPTY;
    }

    /**
     * Convert LocalDate to String with user defined formatter
     *
     * @param localDate LocalDate
     * @param formatter DateTimeFormatter
     * @return String
     */
    public static String localDateToString(LocalDate localDate, DateTimeFormatter formatter) {
        return ObjectUtils.isNotEmpty(localDate) ? localDate.format(formatter) : StringUtils.EMPTY;
    }

    /**
     * Convert LocalDateTime to String by given formatter
     *
     * @param localDateTime LocalDateTime (yyyy-MM-dd HH:mm:ss)
     * @return String
     */
    public static String localDateTimeToString(LocalDateTime localDateTime) {
        return ObjectUtils.isNotEmpty(localDateTime) ? localDateTime.format(DateConstants.YYYY_MM_DD_HH_MM_SS) : StringUtils.EMPTY;
    }

    /**
     * Convert LocalDateTime to String with user defined formatter
     *
     * @param localDateTime LocalDateTime
     * @param formatter DateTimeFormatter
     * @return string String
     */
    public static String localDateTimeToString(LocalDateTime localDateTime, DateTimeFormatter formatter) {
        return ObjectUtils.isNotEmpty(localDateTime) ? localDateTime.format(formatter) : StringUtils.EMPTY;
    }

    /**
     * Convert String to localDate by self-defined pattern
     *
     * @param dateString String (String to be converted)
     * @param datePattern String (Pattern of the date)
     * @return LocalDate
     */
    public static LocalDate stringToLocalDate(String dateString, String datePattern) {
        if (StringUtils.isEmpty(dateString) || StringUtils.isEmpty(datePattern)) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(datePattern);
        return LocalDate.parse(dateString, formatter);
    }

    /**
     * Convert String to localDate by self-defined formatter
     *
     * @param date String (String to be converted)
     * @param formatter DateTimeFormatter
     * @return LocalDate
     */
    public static LocalDate stringToLocalDate(String date, DateTimeFormatter formatter) {
        if (StringUtils.isEmpty(date) || ObjectUtils.isEmpty(formatter)) {
            return null;
        }
        return LocalDate.parse(date, formatter);
    }

    /**
     * Convert String to localDateTime by self-defined pattern
     *
     * @param dateTimeString String (String to be converted)
     * @param dateTimePattern String (Pattern of the date)
     * @return LocalDateTime
     */
    public static LocalDateTime stringToLocalDateTime(String dateTimeString, String dateTimePattern) {
        if (StringUtils.isEmpty(dateTimeString) || StringUtils.isEmpty(dateTimePattern)) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimePattern);
        return LocalDateTime.parse(dateTimeString, formatter);
    }

    /**
     * Calculate the difference between two dates (unit: days)
     *
     * @param startDate LocalDate (Start date)
     * @param endDate LocalDate (End date)
     */
    public static Long getDateDifferenceAsDays(LocalDate startDate, LocalDate endDate) {
        if (ObjectUtils.isEmpty(startDate) || ObjectUtils.isEmpty(endDate)) {
            return null;
        }
        // Swap the dates if the start date is after the end date
        if (startDate.isAfter(endDate)) {
            LocalDate tmpDate = endDate;
            startDate = endDate;
            endDate = tmpDate;
        }
        return ChronoUnit.DAYS.between(startDate, endDate);
    }

    /**
     * Retrieve the number of days in a specific month of a given year
     *
     * @param year year
     * @param month month
     * @return length of days in month
     */
    public static int getLengthOfDaysInMonth(int year, int month) {
        return LocalDate.of(year, month, 1).lengthOfMonth();
    }

    /**
     * Determine if the date is valid with user-defined pattern
     *
     * @param date String
     * @param pattern String, user-defined pattern
     * @return true/false
     */
    public static boolean isValidDate(String date, String pattern) {
        if (StringUtils.isEmpty(date) || StringUtils.isEmpty(pattern)) {
            return false;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        try {
            LocalDate.parse(date, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    /**
     * Convert LocalDateTime to Minguo date format (yyyy-MM-dd)
     *
     * @param localDateTime
     * @return
     */
    public static String formatMinGuoDate(LocalDateTime localDateTime) {
        if (ObjectUtils.isEmpty(localDateTime)) {
            return StringUtils.EMPTY;
        }
        return MinguoChronology.INSTANCE.localDateTime(localDateTime).format(DateConstants.MINGUO_FORMATTER_ISO);
    }



}
