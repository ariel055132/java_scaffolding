import cn.hutool.core.util.DesensitizedUtil;

/**
 * 使用 hutools 工具类进行脱敏
 * 如果是用在 CHN 的 project，可考慮使用它進行脱敏
 */

public class DesensitizedUtilHutool extends DesensitizedUtil {
    // Constructor
    public DesensitizedUtilHutool() {

    }


    public static String carLicense(String carLicense) {
        return DesensitizedUtil.carLicense(carLicense);
    }
}
