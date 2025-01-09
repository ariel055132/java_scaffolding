import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnnotationTest {
    @Test
    @DisplayName("Test annotation")
    void testAnnotation() throws JsonProcessingException {
        // Given
        DesensitizedAnnotationTest test = new DesensitizedAnnotationTest();
        test.setEnglishName("John Doe");
        test.setChineseName("王小明");
        test.setBirthDate("1990-01-01");
        test.setIdNumber("A123456789");
        test.setPhoneNumber("0212345678");
        test.setCellPhoneNumber("0912345678");
        test.setChineseAddress("台北市信義區信義路");
        test.setEnglishAddress("No. 1, Sec. 1, Xinyi Rd., Xinyi Dist., Taipei City");
        test.setEmail("xinyi@yahoo.com");
        // Serialize to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResult = objectMapper.writeValueAsString(test);
        System.out.println(jsonResult);
    }
}
