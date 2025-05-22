package com.test.common.codec;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CaesarUtilsTest {
    @Test
    @DisplayName("Test CaesarUtilsTest")
    void testCaesarUtils() {
        String str = "1f2e9df6131b480b9fdddc633cf24996";

        String encode = CaesarUtils.encode(str, 3);
        assertEquals("1H2G9FH6131D480D9HFFFE633EH24996", encode);

        String decode = CaesarUtils.decode(encode, 3);
        assertEquals(str, decode);
    }
}
