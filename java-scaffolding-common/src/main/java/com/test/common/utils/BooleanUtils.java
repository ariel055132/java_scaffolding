package com.test.common.utils;

import com.test.common.constants.BooleanConstants;
import org.apache.commons.lang3.ObjectUtils;

/**
 * Boolean 布林共用函式
 *
 * @author Adrian
 * @date 2024/11/16
 */

public class BooleanUtils extends org.apache.commons.lang3.BooleanUtils {
    public static boolean isTure(Boolean bool) {
        return org.apache.commons.lang3.BooleanUtils.isTrue(bool);
    }

    public static boolean isFalse(Boolean bool) {
        return org.apache.commons.lang3.BooleanUtils.isFalse(bool);
    }

    /**
     * Not Operation
     *
     * @param bool Boolean to be converted
     * @return Converted Boolean (True -> False, False -> True, Null -> Null)
     */
    public static Boolean not(Boolean bool) {
        if (ObjectUtils.isEmpty(bool)) {
            return null;
        }
        return bool ? BooleanConstants.FALSE : BooleanConstants.TRUE;
    }

    /**
     * And Operation
     *
     * @param boolArray Boolean Array to be checked
     * @return True if all are True, False if any one is False, Null if any one is Null
     */
    public static Boolean and(Boolean ...boolArray) {
        return org.apache.commons.lang3.BooleanUtils.and(boolArray);
    }

    /**
     * Or Operation
     *
     * @param boolArray Boolean Array to be checked
     * @return True if any one is True, False if all are False, Null if any one is Null
     */
    public static Boolean or(Boolean ...boolArray) {
        return org.apache.commons.lang3.BooleanUtils.or(boolArray);
    }
}
