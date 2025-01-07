package util;

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

    /**
     * 中國地區的名字脫敏
     * Desensitization of name in China
     * 只显示第一个汉字，其他隐藏为2个星号，比如：李**
     *
     * @param chineseName String 脫敏前的名字 (Name before desensitization)
     * @return String 脫敏後的名字 (Desensitized name)
     */
    public static String chineseName(String chineseName) {
        return DesensitizedUtil.chineseName(chineseName);
    }

    /**
     * 中國地區的密碼脫敏
     * Desensitization of password in China
     * 全部隐藏为星号，比如：******
     *
     * @param password
     * @return
     */
    public static String password(String password) {
        return DesensitizedUtil.password(password);
    }

    /**
     * 中國地區的銀行卡號脫敏
     * Desensitization of bank card number in China
     * 只展示前4位，后面的位数根据卡号决定展示1-4位，如下所示
     * "1234 2222 3333 4444 6789 9"    ->   "1234 **** **** **** **** 9"
     * "1234 2222 3333 4444 6789 91"   ->   "1234 **** **** **** **** 91"
     * "1234 2222 3333 4444 678"       ->   "1234 **** **** **** 678"
     * "1234 2222 3333 4444 6789"      ->   "1234 **** **** **** 6789"
     * @param bankCardNo
     * @return
     */
    public static String bankCard(String bankCardNo) {
        return DesensitizedUtil.bankCard(bankCardNo);
    }

    /**
     * 中國地區的 iPv4 地址脫敏
     * Desensitization of IPv4 address in China
     * 只顯示前三位，後面的全部以 * 表示
     * E.G: 192.0.2.1 -> 192.*.*.*
     *
     * @param ipv4Address String 脫敏前的 IPv4 地址 (IPv4 address before desensitization)
     * @return String 脫敏後的 IPv4 地址 (Desensitized IPv4 address)
     */
    public static String ipv4(String ipv4Address) {
        return DesensitizedUtil.ipv4(ipv4Address);
    }

    /**
     * 中國地區的 IPv6 地址脫敏
     * Desensitization of IPv6 address in China
     * 脫敏範例: 2001:0db8:86a3:08d3:1319:8a2e:0370:7344 -> 2001:*:*:*:*:*:*:*
     *
     * @param ipv6Address
     * @return
     */
    public static String ipv6(String ipv6Address) {
        return DesensitizedUtil.ipv6(ipv6Address);
    }

    /**
     * 中國地區的(固定)電話號碼脫敏
     * Desensitization of fixed phone number in China
     * 只顯示前四位，和最後的兩位，中間的數字以 * 表示
     * E.G: 13800138000 -> 1380*****00
     *
     * @param fixedPhoneNumber String 脫敏前的(固定)電話號碼 (Fixed Phone number before desensitization)
     * @return String 脫敏後的(固定)電話號碼 (Desensitized fixed phone number)
     */
    public static String fixedPhone(String fixedPhoneNumber) {
        return DesensitizedUtil.fixedPhone(fixedPhoneNumber);
    }

    /**
     * 中國地區的(行動)電話號碼脫敏
     * Desensitization of mobile phone number in China
     * 只顯示前三位，和最後的四位，其他的數字以 * 表示
     *
     * @param mobilePhoneNumber String 脫敏前的(行動)電話號碼 (Mobile phone number before desensitization)
     * @return String 脫敏後的(行動)電話號碼 (Desensitized mobile phone number)
     */
    public static String mobilePhone(String mobilePhoneNumber) {
        return DesensitizedUtil.mobilePhone(mobilePhoneNumber);
    }

}
