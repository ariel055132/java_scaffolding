package com.test.common.codec;

import com.test.common.utils.StringUtils;

import java.io.UnsupportedEncodingException;

public class Base64Utils extends org.apache.commons.codec.binary.Base64 {
    // Constructor
    public Base64Utils() {
    }

    /**
     * Encodes a string into its base64 representation.
     * Encoding: UTF-8
     *
     * @param string The string to encode
     * @param charset The charset to use for encoding, if null then UTF-8 is used
     * @return The base64 representation of the string
     */
    public static String encodeToString(String string, String charset) {
        if (StringUtils.isEmpty(charset)) {
            return org.apache.commons.codec.binary.Base64.encodeBase64String(string.getBytes());
        }
        try {
            return org.apache.commons.codec.binary.Base64.encodeBase64String(string.getBytes(charset));
        } catch (UnsupportedEncodingException e) {
            return "Wrong/Unknown charset";
        }
    }

    /**
     * Decodes a base64 encoded string into its original representation.
     * Encoding: UTF-8
     *
     * @param string The base64 encoded string to decode
     * @return The original representation of the base64 encoded string
     */
    public static String decodeToString(String string) {
        return new String(org.apache.commons.codec.binary.Base64.decodeBase64(string));
    }



}
