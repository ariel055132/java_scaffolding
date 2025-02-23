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
     * Checks if a CharSequence is empty ("") or null.
     *
     * @param cs CharSequence
     * @return boolean
     */
    public static boolean isEmpty(CharSequence cs) {
        return org.apache.commons.lang3.StringUtils.isEmpty(cs);
    }

    /**
     * Extract substring from a given string, starting from a specific index
     *
     * @param str Given String
     * @param start Starting index
     * @return subString (substring from start index to end of the string)
     */
    public static String substring(String str, int start) {
        return org.apache.commons.lang3.StringUtils.substring(str, start);
    }

    /**
     * Extract substring from a given string, starting from a specific index to the end index
     *
     * @param str Given String
     * @param start Starting index
     * @param end Ending index
     * @return subString (substring from start index to end index)
     */
    public static String substring(String str, int start, int end) {
        return org.apache.commons.lang3.StringUtils.substring(str, start, end);
    }

    /**
     * Pad the existing string to the specified length
     * If the size of existing string exceeds the desired size, return this string
     * Pad the string in front of existing string
     *
     * @param str Given String
     * @param size the desired length after padding
     * @param padChar the character to pad the string with
     * @return the padded string
     */
    public static String leftPad(String str, int size, char padChar) {
        return org.apache.commons.lang3.StringUtils.leftPad(str, size, padChar);
    }

    /**
     * Pad the existing string to the specified length
     * If the size of existing string exceeds the desired size, return this string
     * Pad the string after the existing string
     *
     * @param str Given String
     * @param size the desired length after padding
     * @param padChar the character to pad the string with
     * @return the padded string
     */
    public static String rightPad(String str, int size, char padChar) {
        return org.apache.commons.lang3.StringUtils.rightPad(str, size, padChar);
    }

    /**
     * Check if a given string contains any full-width characters
     *
     * @param inputString String
     * @return true/false
     */
    public static boolean containsFullWidth(String inputString) {
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
     * Check if a given string contains any half-width characters
     *
     * @param inputString String
     * @return true/false
     */
    public static boolean containsHalfWidth(String inputString) {
        // 1. Check if the inputString is empty or null, if so, return false
        if (StringUtils.isEmpty(inputString)) {
            return false;
        }
        /* 2. Iterate through each character in the inputString
         * For each character, it calls the isHalfWidth method to check if it is a half-width character
         * If any character in the string is found to be a half-width character, return true
         * Otherwise, return false
         */
        for (char c : inputString.toCharArray()) {
            if (isHalfWidth(c)) {
                return true;
            }
        }
        return false;
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
    public static boolean isHalfWidth(char c) {
        return !isFullWidth(c);
    }

    /**
     * Convert a half-width string to full-width
     *
     * @param halfWidthString
     * @return full-width string
     */
    public static String convertToFullWidth(String halfWidthString) {
        if (StringUtils.isEmpty(halfWidthString)) {
            return halfWidthString;
        }
        char[] arr = halfWidthString.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int charValue = arr[i];
            if (charValue >= 33 && charValue <= 126) {
                arr[i] = (char) (charValue + 65248);
            } else if (charValue == 32) {
                arr[i] = (char) 12288;
            }
        }
        return new String(arr);
    }

    /**
     * Convert a full-width string to half-width String
     *
     * @param fullWidthString
     * @return half-width String
     */
    public static String convertToHalfWidth(String fullWidthString) {
        if (StringUtils.isEmpty(fullWidthString)) {
            return fullWidthString;
        }
        char[] arr = fullWidthString.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int charValue = arr[i];
            if (charValue >= 65281 && charValue <= 65374) {
                arr[i] = (char) (charValue - 65248);
            } else if (charValue == 12288) {
                arr[i] = (char) 32;
            }
        }
        return new String(arr);
    }

}
