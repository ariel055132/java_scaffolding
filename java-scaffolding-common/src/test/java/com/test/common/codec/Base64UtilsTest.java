package com.test.common.codec;

import com.test.common.utils.CharsetUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test class for Base64Utils
 */

public class Base64UtilsTest {
    @Test
    @DisplayName("Test encodeBase64")
    void testEncodeBase64() {
        // Given
        String input = ":";
        String charsetEnum = CharsetUtils.UTF_8;
        // When
        String actualResult = Base64Utils.encodeToString(input, charsetEnum);
        // Then
        Assertions.assertEquals("Og==", actualResult);
    }

    @Test
    @DisplayName("Test decodeBase64")
    void testDecodeBase64() {
        // Given
        String input = "Og==";
        String charset = CharsetUtils.UTF_8;
        // When
        String actualResult = Base64Utils.decodeToString(input, charset);
        // Then
        Assertions.assertEquals(":", actualResult);
    }

    @Test
    @DisplayName("Test encodeBase64 with Simplified Chinese (Encoding: UTF-8)")
    void testEncodeBase64WithSimplifiedChineseUTF8() {
        // Given
        String input = "订购成功立即生效，30天内可观看专区中除单独计费影片外的所有内容，到期自动取消。";
        String expectedResult = "6K6i6LSt5oiQ5Yqf56uL5Y2z55Sf5pWI77yMMzDlpKnlhoXlj6/op4LnnIvkuJPljLrkuK3pmaTljZXni6zorqHotLnlvbHniYflpJbnmoTmiYDmnInlhoXlrrnvvIzliLDmnJ/oh6rliqjlj5bmtojjgII=";
        String charset = CharsetUtils.UTF_8;
        // When
        String actualResult = Base64Utils.encodeToString(input, charset);
        // Then
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test encodeBase64 with Simplified Chinese (Encoding: GBK)")
    void testEncodeBase64WithSimplifiedChineseGBK() {
        // Given
        String input = "订购成功立即生效，30天内可观看专区中除单独计费影片外的所有内容，到期自动取消。";
        String expectedResult = "tqm5urPJuabBory0yfrQp6OsMzDM7MTav8m527+016jH+NbQs/21pbbAvMa30dOwxqzN4rXEy/nT0MTayN2jrLW9xtrX1LavyKHP+6Gj";
        String charsetEnum = CharsetUtils.GBK;
        // When
        String actualResult = Base64Utils.encodeToString(input, charsetEnum);
        // Then
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test decodeBase64 with Simplified Chinese (Encoding: GBK)")
    void testDecodeBase64WithSimplifiedChineseGBK() {
        // Given
        String input = "tqm5urPJuabBory0yfrQp6OsMzDM7MTav8m527+016jH+NbQs/21pbbAvMa30dOwxqzN4rXEy/nT0MTayN2jrLW9xtrX1LavyKHP+6Gj";
        String expectedResult = "订购成功立即生效，30天内可观看专区中除单独计费影片外的所有内容，到期自动取消。";
        String charsetEnum = CharsetUtils.GBK;
        // When
        String actualResult = Base64Utils.decodeToString(input, charsetEnum);
        // Then
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
