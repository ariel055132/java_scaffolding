package com.test.common.utils;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;

/**
 * CharsetUtils
 */

public class CharsetUtils {

    public static final String ISO_8859_1 = "ISO-8859-1";
    public static final String UTF_8 = "UTF-8";
    public static final String GBK = "GBK";

    public static final Charset CHARSET_ISO_8859_1 = StandardCharsets.ISO_8859_1;
    public static final Charset CHARSET_UTF_8 = StandardCharsets.UTF_8;
    public static final Charset CHARSET_GBK = charset(GBK);

    public static Charset charset(String charsetName) throws UnsupportedCharsetException {
        return StringUtils.isBlank(charsetName) ? Charset.defaultCharset() : Charset.forName(charsetName);
    }
}
