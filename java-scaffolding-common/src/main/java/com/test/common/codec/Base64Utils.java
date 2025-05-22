package com.test.common.codec;

import com.test.common.utils.CharsetUtils;
import com.test.common.utils.StringUtils;
import org.apache.commons.codec.binary.Base64;

import java.nio.charset.Charset;

public class Base64Utils extends Base64 {
    // Constructor
    public Base64Utils() {
    }

    /**
     * Encodes a string into its base64 representation.
     * Encoding: UTF-8 (default)
     *
     * @param string The string to encode
     * @param charset The charset to use for encoding, if null then UTF-8 is used
     * @return The base64 representation of the string
     */
    public static String encodeToString(String string, String charset) {
        if (StringUtils.isBlank(charset)) {
            return org.apache.commons.codec.binary.Base64.encodeBase64String(string.getBytes(CharsetUtils.CHARSET_UTF_8));
        }
        Charset actualCharset = CharsetUtils.charset(charset);
        return org.apache.commons.codec.binary.Base64.encodeBase64String(string.getBytes(actualCharset));
    }

    /**
     * Decodes a base64 encoded string into its original representation.
     * Encoding: UTF-8
     *
     * @param string The base64 encoded string to decode
     * @param charset The charset to use for decoding, if null then UTF-8 is used
     * @return The original representation of the base64 encoded string
     */
    public static String decodeToString(String string, String charset) {
        if (StringUtils.isBlank(charset)) {
            return new String(org.apache.commons.codec.binary.Base64.decodeBase64(string), CharsetUtils.CHARSET_UTF_8);
        }
        // Decode from Base64
        byte[] decodedBytes = org.apache.commons.codec.binary.Base64.decodeBase64(string);
        // Convert Bytes to String using the specified charset
        String decodedString = new String(decodedBytes, CharsetUtils.charset(charset));
        return decodedString;
    }

}
