import com.test.common.sensitive.util.DesensitizedUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DesensitizedUtilsTest {
    @Test
    @DisplayName("處理中文姓名(>2個字元)")
    void testDesensitizeChineseName() {
        // Given
        String chineseName = "王小明";
        // When
        String actualResult = DesensitizedUtils.chineseName(chineseName);
        // Then
        Assertions.assertEquals("王*明", actualResult);
    }

    @Test
    @DisplayName("處理中文姓名(=2個字元)")
    void testDesensitizeChineseNameWithTwoCharacters() {
        // Given
        String chineseName = "王小";
        // When
        String actualResult = DesensitizedUtils.chineseName(chineseName);
        // Then
        Assertions.assertEquals("王*", actualResult);
    }

    @Test
    @DisplayName("處理英文姓名")
    void testDesensitizeEnglishName() {
        // Given
        String englishName = "John Doe";
        // When
        String actualResult = DesensitizedUtils.englishName(englishName);
        // Then
        Assertions.assertEquals("Jo** Do*", actualResult);
    }

    @Test
    @DisplayName("處理電話號碼")
    void phoneNumber() {
        // Given
        String phoneNumber = "0912345678";
        // When
        String actualResult = DesensitizedUtils.phoneNumber(phoneNumber);
        // Then
        Assertions.assertEquals("0912***78", actualResult);
    }
}
