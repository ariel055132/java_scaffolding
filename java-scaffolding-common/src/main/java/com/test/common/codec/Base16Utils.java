package com.test.common.codec;

import com.test.common.utils.StringUtils;
import org.apache.commons.codec.binary.Base16;

public class Base16Utils extends Base16 {
    // Constructor
    public Base16Utils() {
    }


    /**
     * Encodes a string into its base16 representation.
     * Encoding: UTF-8 (default)
     *
     * @param string The string to encode
     * @param charset The charset to use for encoding, if null then UTF-8 is used
     * @return The base16 representation of the string
     */
    public static String encodeToString(String string, String charset) {
        Base16 base16 = new Base16();
        if (StringUtils.isBlank(charset)) {
            return null;
        }
        return null;
    }
}
