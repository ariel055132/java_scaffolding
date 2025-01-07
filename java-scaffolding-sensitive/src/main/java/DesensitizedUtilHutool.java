import cn.hutool.core.util.DesensitizedUtil;

/**
 * 使用 hutools 工具类进行脱敏
 * 如果是用在中國地區的 project，可考慮使用它進行脱敏
 * Use Hutool Utility class for desensitization
 * If the project is used in China, consider using it for desensitization
 */

public class DesensitizedUtilHutool extends DesensitizedUtil {
    // Constructor
    public DesensitizedUtilHutool() {

    }

    /**
     * 中國地區的車牌脫敏
     * Desensitization of car license in China
     *
     * @param carLicense String 脫敏前的車牌號 (Car license before desensitization)
     * @return String 脫敏後的車牌號 (Desensitized car license)
     */
    public static String carLicense(String carLicense) {
        return DesensitizedUtil.carLicense(carLicense);
    }
}
