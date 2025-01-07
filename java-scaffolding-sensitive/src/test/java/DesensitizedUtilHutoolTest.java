import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DesensitizedUtilHutoolTest {
    @Test
    @DisplayName("中國車牌的脫敏測試")
    void testCarLicense() {
        // Given
        String carLicense = "京A12345";
        String expectedResult = "京A1***5";
        // When
        String actualResult = DesensitizedUtilHutool.carLicense(carLicense);
        // Then
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("中國名字的脫敏測試")
    void testChineseName() {
        // Given
        String chineseName = "王小明";
        String expectedResult = "王**";
        // When
        String actualResult = DesensitizedUtilHutool.chineseName(chineseName);
        // Then
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("中國密碼的脫敏測試")
    void testPassword() {
        // Given
        String password = "123456";
        String expectedResult = "******";
        // When
        String actualResult = DesensitizedUtilHutool.password(password);
        // Then
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("中國銀行卡號的脫敏測試")
    void testBankCard() {
        // Given
        String bankCardNo = "1234 2222 3333 4444 6789 9";
        String expectedResult = "1234 **** **** **** **** 9";
        // When
        String actualResult = DesensitizedUtilHutool.bankCard(bankCardNo);
        // Then
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("中國 IPv4 地址的脫敏測試")
    void testIPv4() {
        // Given
        String ipv4 = "192.0.2.1";
        String expectedResult = "192.*.*.*";
        // When
        String actualResult = DesensitizedUtilHutool.ipv4(ipv4);
        // Then
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("中國 IPv6 地址的脫敏測試")
    void testIPv6() {
        // Given
        String ipv6 = "2001:0db8:85a3:0000:0000:8a2e:0370:7334";
        String expectedResult = "2001:*:*:*:*:*:*:*";
        // When
        String actualResult = DesensitizedUtilHutool.ipv6(ipv6);
        // Then
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
