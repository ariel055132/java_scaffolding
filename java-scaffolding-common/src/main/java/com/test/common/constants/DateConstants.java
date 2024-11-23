package com.test.common.constants;

import java.time.chrono.MinguoChronology;
import java.time.format.DateTimeFormatter;

public class DateConstants {
    public static final String S_YYYY_MM_DD_NOSPLIT = "yyyyMMdd";

    public static final String S_YYYY_MM_DD_ISO = "yyyy-MM-dd";

    public static final String S_YYYY_MM_DD_SLASH = "yyyy/MM/dd";

    public static final String S_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static final DateTimeFormatter YYYY_MM_DD_NOSPLIT = DateTimeFormatter.ofPattern(S_YYYY_MM_DD_NOSPLIT);

    public static final DateTimeFormatter YYYY_MM_DD_ISO = DateTimeFormatter.ofPattern(S_YYYY_MM_DD_ISO);

    public static final DateTimeFormatter YYYY_MM_DD_SLASH = DateTimeFormatter.ofPattern(S_YYYY_MM_DD_SLASH);

    public static final DateTimeFormatter YYYY_MM_DD_HH_MM_SS = DateTimeFormatter.ofPattern(S_YYYY_MM_DD_HH_MM_SS);

    public static final DateTimeFormatter MINGUO_FORMATTER_ISO = DateTimeFormatter.ofPattern(S_YYYY_MM_DD_ISO).withChronology(MinguoChronology.INSTANCE);

    public static final DateTimeFormatter MINGUO_FORMATTER_SLASH = DateTimeFormatter.ofPattern(S_YYYY_MM_DD_SLASH).withChronology(MinguoChronology.INSTANCE);

    public static final DateTimeFormatter MINGUO_FORMATTER_HH_MM_SS = DateTimeFormatter.ofPattern(S_YYYY_MM_DD_HH_MM_SS).withChronology(MinguoChronology.INSTANCE);
}
