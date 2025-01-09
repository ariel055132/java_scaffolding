import com.test.common.sensitive.annotation.Desensitize;
import com.test.common.sensitive.enums.DesensitizeType;
import lombok.Getter;
import lombok.Setter;

/**
 * 脫敏注解測試用 Entity
 */

@Getter
@Setter
public class DesensitizedAnnotationTest {
    @Desensitize(type = DesensitizeType.CHINESE_NAME)
    private String chineseName;

    @Desensitize(type = DesensitizeType.ENGLISH_NAME)
    private String englishName;

    @Desensitize(type = DesensitizeType.BIRTH_DATE)
    private String birthDate;

    @Desensitize(type = DesensitizeType.ID_NUMBER)
    private String idNumber;

    @Desensitize(type = DesensitizeType.PHONE_NUMBER)
    private String phoneNumber;

    @Desensitize(type = DesensitizeType.CELL_PHONE_NUMBER)
    private String cellPhoneNumber;

    @Desensitize(type = DesensitizeType.CHINESE_ADDRESS)
    private String chineseAddress;

    @Desensitize(type = DesensitizeType.ENGLISH_ADDRESS)
    private String englishAddress;

    @Desensitize(type = DesensitizeType.EMAIL)
    private String email;
}

