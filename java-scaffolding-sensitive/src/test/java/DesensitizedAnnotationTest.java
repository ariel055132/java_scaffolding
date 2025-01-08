import com.test.common.sensitive.annotation.Desensitize;
import com.test.common.sensitive.enums.DesensitizeType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DesensitizedAnnotationTest {
    @Desensitize(type = DesensitizeType.CHINESE_NAME)
    private String chineseName;

    @Desensitize(type = DesensitizeType.ENGLISH_NAME)
    private String englishName;
}

