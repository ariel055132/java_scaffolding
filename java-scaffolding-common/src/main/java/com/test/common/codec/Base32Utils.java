package com.test.common.codec;

import com.test.common.utils.StringUtils;
import org.apache.commons.codec.binary.Base32;

public class Base32Utils extends org.apache.commons.codec.binary.Base32 {
    // Constructor
    public Base32Utils() {
    }

    /**
     * Encodes a string into its base32 representation.
     * Encoding: UTF-8 (default)
     *
     * @param string The string to encode
     * @param charset The charset to use for encoding, if null then UTF-8 is used
     * @return The base32 representation of the string
     */
    public static String encodeToString(String string, String charset) {
        Base32 base32 = new Base32();
        if (StringUtils.isBlank(charset)) {
            return new String(base32.encode(string.getBytes(com.test.common.utils.CharsetUtils.CHARSET_UTF_8)));
        }
        return new String(base32.encode(string.getBytes(com.test.common.utils.CharsetUtils.charset(charset))));
    }

    /**
     * Decodes a base32 encoded string into its original representation.
     * Encoding: UTF-8
     *
     * @param string The base32 encoded string to decode
     * @param charset The charset to use for decoding, if null then UTF-8 is used
     * @return The original representation of the base32 encoded string
     */
    public static String decodeToString(String string, String charset) {
        Base32 base32 = new Base32();
        if (com.test.common.utils.StringUtils.isBlank(charset)) {
            base32.decode(string.getBytes(com.test.common.utils.CharsetUtils.CHARSET_UTF_8));
            return string;
        }
        base32.decode(string.getBytes(com.test.common.utils.CharsetUtils.charset(charset)));
        return string;
    }
}
