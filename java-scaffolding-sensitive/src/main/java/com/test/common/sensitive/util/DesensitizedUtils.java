package com.test.common.sensitive.util;

import com.test.common.constants.StringConstants;
import com.test.common.utils.StringUtils;

/**
 * 自定義敏感資料處理共用函式
 * Custom sensitive data processing common functions
 * 處理 中文姓名，英文姓名，出生年月日，身分證字號，電話號碼，行動電話，中文地址，英文地址，電子郵件
 * Process Chinese Name, English Name, Birth Date, ID Number, Phone Number, Cell Phone Number, Chinese Address, English Address, Email
 */
public class DesensitizedUtils {
    /**
     * 中文姓名(顯示姓氏第一個及最後一個中文字，單名者顯示姓氏，其他以星號遮蔽)
     * Chinese Name
     * Display the first and last Chinese characters of the surname, display the surname for single names, and mask the rest with asterisks
     * @param chineseName 中文姓名 (Input Chinese Name)
     * @return 處理後的中文姓名 (Desensitized Chinese Name)
     */
    public static String chineseName(String chineseName) {
        // 空值或空字串，直接回傳空字串
        if (StringUtils.isEmpty(chineseName)) {
            return StringConstants.EMPTY;
        }
        chineseName = chineseName.trim();
        int chineseNameLength = chineseName.length();
        StringBuilder sb = new StringBuilder();

        // 只有姓氏，直接回傳
        if (chineseNameLength == 1) {
            return chineseName;
        } // 單名者顯示姓氏
        else if (chineseNameLength == 2) {
            sb.append(chineseName.charAt(0));
            sb.append(StringConstants.STAR);
        } // 顯示姓氏第一個及最後一個中文字
        else {
            sb.append(chineseName.charAt(0));
            sb.append(StringConstants.STAR.repeat(chineseNameLength - 2));
            sb.append(chineseName.charAt(chineseNameLength - 1));
        }
        return sb.toString();
    }

    /**
     * 英文姓名
     * 名和姓各顯示第一個和第二個字母，其他以星號遮蔽
     * English Name
     * Display the first and second letters of both the first name and last name, and mask the rest with asterisks.
     * E.G: "John Doe" -> "Jo** D**"
     * @param englishName 英文姓名 (Input Chinese Name)
     * @return 處理後的英文姓名 (Desensitized English Name)
     */
    public static String englishName(String englishName) {
        if (StringUtils.isEmpty(englishName)) {
            return StringConstants.EMPTY;
        }
        englishName = englishName.trim();
        String[] names = englishName.split(StringConstants.SPACE);
        StringBuilder sb = new StringBuilder();

        for (String name : names) {
            if (name.length() < 2) {
                sb.append(name);
            } else {
                sb.append(name.charAt(0));
                sb.append(name.charAt(1));
                sb.append(StringConstants.STAR.repeat(name.length() - 2));
            }
            sb.append(StringConstants.SPACE);
        }
        return sb.toString().trim();
    }

    /**
     * 出生年月日
     * 以星號遮蔽月及日
     * Birth Date
     * Mask the month and day with asterisks
     * @param birthDate 出生年月日 (input birthdate, format: YYYYMMDD)
     * @return 處理後的出生年月日 (desensitized birthdate, result format: YYYY****)
     */
    public static String birthDate(String birthDate) {
        if (StringUtils.isEmpty(birthDate)) {
            return StringConstants.EMPTY;
        }
        return birthDate.substring(0, 4) + StringConstants.STAR.repeat(4);
    }

    /**
     * 身分證字號
     * 以星號遮蔽末四碼
     * ID Number
     * Mask the last four digits with asterisks
     */
    public static String idNumber(String idNumber) {
        if (StringUtils.isEmpty(idNumber)) {
            return StringConstants.EMPTY;
        }
        idNumber = idNumber.trim();
        int idNumberLength = idNumber.length();
        if (idNumberLength < 5) {
            return idNumber;
        }
        return idNumber.substring(0, idNumber.length() - 4) + StringConstants.STAR.repeat(4);
    }

    /**
     * 電話號碼
     * 第五碼（含）起以星號遮蔽三碼（不含國碼及區域碼）
     * Phone Number
     * Mask the middle four digits with asterisks
     * E.G: "0912345678" -> "0912****678"
     * @param phoneNumber 電話號碼 (input phone number)
     * @return 處理後的電話號碼 (desensitized phone number)
     */
    public static String phoneNumber(String phoneNumber) {
        if (StringUtils.isEmpty(phoneNumber)) {
            return StringConstants.EMPTY;
        }
        phoneNumber = phoneNumber.trim().replaceAll("\\D+", "");
        int phoneNumberLength = phoneNumber.length();
        if (phoneNumberLength < 4) {
            return phoneNumber;
        } else if (phoneNumberLength < 7) {
            return phoneNumber.substring(0, 4) + StringConstants.STAR.repeat(phoneNumberLength - 4);
        }
        return phoneNumber.substring(0, 4) + StringConstants.STAR.repeat(3) + phoneNumber.substring(8, phoneNumberLength);
    }

    /**
     * 行動電話
     * 第五碼（含）起以星號遮蔽六碼（不含國碼）
     * Cell Phone Number
     * Mask the middle six digits with asterisks
     * E.G: "0912345678" -> "0912******"
     * @param cellPhoneNumber 行動電話 (input cell phone number)
     * @return 處理後的行動電話 (desensitized cell phone number)
     */
    public static String cellPhoneNumber(String cellPhoneNumber) {
        if (StringUtils.isEmpty(cellPhoneNumber)) {
            return StringConstants.EMPTY;
        }
        cellPhoneNumber = cellPhoneNumber.trim().replaceAll("\\D+", "");
        int cellPhoneNumberLength = cellPhoneNumber.length();
        if (cellPhoneNumberLength < 5) {
            return cellPhoneNumber;
        } else if (cellPhoneNumberLength < 10) {
            return cellPhoneNumber.substring(0, 4) + StringConstants.STAR.repeat(cellPhoneNumberLength - 4);
        }
        return cellPhoneNumber.substring(0, 4) + StringConstants.STAR.repeat(6) + cellPhoneNumber.substring(10, cellPhoneNumberLength);
    }

    /**
     * 中文地址
     * 自第七碼（含）起以星號遮蔽
     * chinese address
     * Mask the address from the seventh digit (inclusive) with asterisks
     * @param chineseAddress 中文地址 (Input Chinese Address)
     * @return 處理後的中文地址 (Desensitized Chinese Address)
     */
    public static String chineseAddress(String chineseAddress) {
        if (StringUtils.isEmpty(chineseAddress)) {
            return StringConstants.EMPTY;
        }
        chineseAddress = chineseAddress.trim();
        int chineseAddressLength = chineseAddress.length();
        if (chineseAddressLength < 7) {
            return chineseAddress;
        }
        return chineseAddress.substring(0, 6) + StringConstants.STAR.repeat(chineseAddressLength - 6);
    }

    /**
     * 英文地址
     * 自第四碼（含）起以星號遮蔽
     * english address
     * Mask the address from the fourth digit (inclusive) with asterisks
     * @param englishAddress 英文地址 (Input English Address)
     * @return 處理後的英文地址 (Desensitized English Address)
     */
    public static String englishAddress(String englishAddress) {
        if (StringUtils.isEmpty(englishAddress)) {
            return StringConstants.EMPTY;
        }
        englishAddress = englishAddress.trim();
        int englishAddressLength = englishAddress.length();
        if (englishAddressLength < 4) {
            return englishAddress;
        }
        return englishAddress.substring(0, 4) + StringConstants.STAR.repeat(englishAddressLength - 4);
    }

    /**
     * 電子郵件
     * 以星號遮蔽第二碼（含）至五碼
     * Email
     * Mask the second digit (inclusive) to the fifth digit with asterisks
     * @param email 電子郵件 (Input Email)
     * @return 處理後的電子郵件 (Desensitized Email)
     */
    public static String email(String email) {
        if (StringUtils.isEmpty(email)) {
            return StringConstants.EMPTY;
        }
        email = email.trim();
        int emailLength = email.length();
        if (emailLength < 2) {
            return email;
        } else if (emailLength < 6) {
            return email.substring(0, 1) + StringConstants.STAR.repeat(emailLength - 1);
        }
        return email.substring(0, 2) + StringConstants.STAR.repeat(4) + email.substring(6, emailLength);
    }

}
