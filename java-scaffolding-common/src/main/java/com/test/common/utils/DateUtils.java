package com.test.common.utils;

import com.test.common.constants.DateConstants;
import org.apache.commons.lang3.ObjectUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        return ObjectUtils.isNotEmpty(localDate) ? localDate.format(DateConstants.YYYY_MM_DD) : StringUtils.EMPTY;
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


}
