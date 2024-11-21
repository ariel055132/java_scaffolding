package com.test.common.constants;

import java.time.format.DateTimeFormatter;

public class DateConstants {
    public static final String S_YYYY_MM_DD = "yyyyMMdd";

    public static final String S_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static final DateTimeFormatter YYYY_MM_DD = DateTimeFormatter.ofPattern(S_YYYY_MM_DD);

    public static final DateTimeFormatter YYYY_MM_DD_HH_MM_SS = DateTimeFormatter.ofPattern(S_YYYY_MM_DD_HH_MM_SS);

}
