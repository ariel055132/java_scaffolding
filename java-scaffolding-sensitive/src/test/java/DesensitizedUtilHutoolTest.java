import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DesensitizedUtilHutoolTest {
    @Test
    void testCarLicense() {
        // Given
        String carLicense = "京A12345";
        // When
        String actualResult = DesensitizedUtilHutool.carLicense(carLicense);
        // Then
        Assertions.assertEquals("京A1***5", actualResult);
    }
}
