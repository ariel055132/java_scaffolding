package com.test.common.utils;

/**
 * String 字符共用函式
 *
 * @author Adrian
 * @date 2024/11/16
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {
    /**
     * Checks if a given CharSequence contains another CharSequence
     *
     * @param str CharSequence (The Sequence to be search)
     * @param searchStr CharSequence (The Sequence to search for)
     * @return boolean (true if the search CharSequence is found, false otherwise)
     */
    public static boolean contains(CharSequence str, CharSequence searchStr) {
        return org.apache.commons.lang3.StringUtils.contains(str, searchStr);
    }

    /**
     * Checks if a given CharSequence contains another CharSequence, ignoring case
     *
     * @param str CharSequence (The Sequence to be search)
     * @param searchStr CharSequence (The Sequence to search for)
     * @return boolean (true if the search CharSequence is found, false otherwise)
     */
    public static boolean containsIgnoreCase(CharSequence str, CharSequence searchStr) {
        return org.apache.commons.lang3.StringUtils.containsIgnoreCase(str, searchStr);
    }

    /**
     * Checks if two CharSequence instances are equal
     *
     * @param cs1 CharSequence (The CharSequence to be checked)
     * @param cs2 CharSequence (The CharSequence to check for)
     * @return boolean
     */
    public static boolean equals(CharSequence cs1, CharSequence cs2) {
        return org.apache.commons.lang3.StringUtils.equals(cs1, cs2);
    }

    /**
     * Checks if two CharSequence instances are equal, ignoring case.
     *
     * @param cs1 CharSequence
     * @param cs2 CharSequence
     * @return boolean
     */
    public static boolean equalsIgnoreCase(CharSequence cs1, CharSequence cs2) {
        return org.apache.commons.lang3.StringUtils.equalsIgnoreCase(cs1, cs2);
    }

    /**
     * Checks if a CharSequence is empty ("") or null.
     *
     * @param cs CharSequence
     * @return boolean
     */
    public static boolean isEmpty(CharSequence cs) {
        return org.apache.commons.lang3.StringUtils.isEmpty(cs);
    }


}
