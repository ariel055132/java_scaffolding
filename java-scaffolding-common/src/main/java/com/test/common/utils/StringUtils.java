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
     * Checks if a CharSequence is empty ("") or null.
     *
     * @param cs CharSequence (The CharSequence to be checked)
     * @return boolean (true if the CharSequence is empty or null, false otherwise)
     */
    public static boolean equals(CharSequence cs1, CharSequence cs2) {
        return org.apache.commons.lang3.StringUtils.equals(cs1, cs2);
    }




}
