package com.test.common.enums;

import java.util.Calendar;

/**
 * Week Enum
 * 星期列舉
 * <p>
 * @see Calendar#SUNDAY
 * @see Calendar#MONDAY
 * @see Calendar#TUESDAY
 * @see Calendar#WEDNESDAY
 * @see Calendar#THURSDAY
 * @see Calendar#FRIDAY
 * @see Calendar#SATURDAY
 */


public enum Week {
    /**
     * Sunday 週日 / 星期日
     * 對應 Java.Calendar.SUNDAY, value = 1
     * @see Calendar#SUNDAY
     */
    SUNDAY(Calendar.SUNDAY),

    /**
     * Monday 週一 / 星期一
     * 對應 Java.Calendar.MONDAY, value = 2
     * @see Calendar#MONDAY
     */
    MONDAY(Calendar.MONDAY),

    /**
     * Tuesday 週二 / 星期二
     * 對應 Java.Calendar.TUESDAY, value = 3
     * @see Calendar#TUESDAY
     */
    TUESDAY(Calendar.TUESDAY),

    /**
     * Wednesday 週三 / 星期三
     * 對應 Java.Calendar.WEDNESDAY, value = 4
     * @see Calendar#WEDNESDAY
     */
    WEDNESDAY(Calendar.WEDNESDAY),

    /**
     * Thursday 週四 / 星期四
     * 對應 Java.Calendar.THURSDAY, value = 5
     * @see Calendar#THURSDAY
     */
    THURSDAY(Calendar.THURSDAY),

    /**
     * Friday 週五 / 星期五
     * 對應 Java.Calendar.FRIDAY, value = 6
     * @see Calendar#FRIDAY
     */
    FRIDAY(Calendar.FRIDAY),

    /**
     * Saturday 週六 / 星期六
     * 對應 Java.Calendar.SATURDAY, value = 7
     * @see Calendar#SATURDAY
     */
    SATURDAY(Calendar.SATURDAY);

    /**
     * Week alias (星期別名)
     */
    private static final String[] WEEK_ALIAS = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

    private static final Week[] ENUMS = Week.values();

    private final int value;

    // Constructor
    Week(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public String getChineseWeek() {
        switch (this) {
            case SUNDAY:
                return "星期日";
            case MONDAY:
                return "星期一";
            default:
                return null;
        }
    }
}
