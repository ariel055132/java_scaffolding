package com.test.common.codec;

import com.test.common.utils.StringUtils;
import com.test.common.utils.CharsetUtils;
import org.apache.commons.codec.binary.Base32;

public class Base32Utils extends Base32 {
    private static final Base32 base32 = new Base32();

    // Constructor
    public Base32Utils() {
    }

    /**
     * Encodes a string into its base32 representation which UTF-8 encoding.
     *
     * @param string The string to encode
     * @return The base32 representation of the string
     */
    public static String encodeToString(String string) {
        if (StringUtils.isBlank(string)) {
            return null;
        }
        return new String(base32.encode(string.getBytes(CharsetUtils.CHARSET_UTF_8)));
    }

    /**
     * Encodes a string into its base32 representation with customized charset.
     *
     * @param string The string to encode
     * @param charset The charset to use for encoding, if null then UTF-8 is used
     * @return The base32 representation of the string
     */
    public static String encodeToString(String string, String charset) {
        if (StringUtils.isBlank(charset)) {
            return encodeToString(string);
        }
        return new String(base32.encode(string.getBytes(CharsetUtils.charset(charset))));
    }

    /**
     * Decodes a base32 encoded string into its original representation, using UTF-8 encoding.
     *
     * @param string The base32 encoded string to decode
     * @return The original representation of the base32 encoded string
     */
    public static String decodeToString(String string) {
        if (StringUtils.isBlank(string)) {
            return null;
        }
        return new String(base32.decode(string.getBytes(CharsetUtils.CHARSET_UTF_8)));
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
        if (StringUtils.isBlank(charset)) {
            return decodeToString(string);
        }
        return new String(base32.decode(string.getBytes(CharsetUtils.charset(charset))));
    }
}
