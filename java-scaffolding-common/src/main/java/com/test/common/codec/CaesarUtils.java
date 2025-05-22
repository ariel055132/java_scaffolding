package com.test.common.codec;

public class CaesarUtils {
    // 26个字母表
    public static final String TABLE = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";

    /**
     * 传入明文，加密得到密文
     *
     * @param message 加密的消息
     * @param offset  偏移量
     * @return 加密后的内容
     */
    public static String encode(String message, int offset) {
        if (message == null) {
            throw new IllegalArgumentException("message must be not null!");
        }
        final int len = message.length();
        final char[] plain = message.toCharArray();
        char c;
        for (int i = 0; i < len; i++) {
            c = message.charAt(i);
            if (false == Character.isLetter(c)) {
                continue;
            }
            plain[i] = encodeChar(c, offset);
        }
        return new String(plain);
    }

    /**
     * 传入明文解密到密文
     *
     * @param cipherText 密文
     * @param offset     偏移量
     * @return 解密后的内容
     */
    public static String decode(String cipherText, int offset) {
        if (cipherText == null) {
            throw new IllegalArgumentException("cipherText must be not null!");
        }
        final int len = cipherText.length();
        final char[] plain = cipherText.toCharArray();
        char c;
        for (int i = 0; i < len; i++) {
            c = cipherText.charAt(i);
            if (false == Character.isLetter(c)) {
                continue;
            }
            plain[i] = decodeChar(c, offset);
        }
        return new String(plain);
    }

    private static char encodeChar(char c, int offset) {
        // 计算偏移量
        int index = TABLE.indexOf(c);
        if (index == -1) {
            return c; // 如果不在字母表中，直接返回原字符
        }
        index = (index + offset) % TABLE.length();
        return TABLE.charAt(index);
    }

    private static char decodeChar(char c, int offset) {
        // 计算偏移量
        int index = TABLE.indexOf(c);
        if (index == -1) {
            return c; // 如果不在字母表中，直接返回原字符
        }
        index = (index - offset + TABLE.length()) % TABLE.length();
        return TABLE.charAt(index);
    }
}
