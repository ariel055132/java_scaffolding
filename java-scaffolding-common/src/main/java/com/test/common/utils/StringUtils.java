package com.test.common.utils;

/**
 * String 字符共用函式
 *
 * @author Adrian
 * @date 2024/11/16
 */

public class StringUtils extends org.apache.commons.lang3.StringUtils {
    // Constructor
    public StringUtils() {

    }

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

    public static <T extends CharSequence> Boolean containsGeneric(T str, T searchStr) {
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
     * Count the number of occurrences of a specific substring within a given string, case sensitive
     *
     * @param str given string
     * @param repeat specific substring
     * @return int (number of occurrences)
     */
    public static int getRepeatCount(String str, String repeat) {
        return org.apache.commons.lang3.StringUtils.countMatches(str, repeat);
    }

    /**
     * Check if a given string contains any full-width characters
     *
     * @param inputString
     * @return
     */
    public static boolean containFullWidth(String inputString) {
        // 1. Check if the inputString is empty or null, if so, return false
        if (StringUtils.isEmpty(inputString)) {
            return false;
        }
        /* 2. Iterate through each character in the inputString
         * For each character, it calls the isFullWidth method to check if it is a full-width character
         * If any character in the string is found to be a full-width character, return true
         * Otherwise, return false
         */
        for (char c : inputString.toCharArray()) {
            if (isFullWidth(c)) {
                return true;
            }
        }
        return false;
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

    /**
     * Determine whether a given character is a full-width (全型) character
     *
     * @param c char
     * @return true/false
     */
    public static boolean isFullWidth(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        return (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION);
    }

    /**
     * Determine whether a given character is a half-width (半型) character
     *
     * @param c char
     * @return true/false
     */
    public static boolean isHashWidth(char c) {
        return !isFullWidth(c);
    }

}
