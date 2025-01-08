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
        // Serialize to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResult = objectMapper.writeValueAsString(test);
        System.out.println(jsonResult);
    }
}
