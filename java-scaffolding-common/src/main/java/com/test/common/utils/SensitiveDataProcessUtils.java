package com.test.common.utils;

import com.test.common.constants.StringConstants;

/**
 * 敏感資料處理共用函式
 * 處理 中文姓名，英文姓名，出生年月日，身分證字號，電話號碼，行動電話，中文地址，英文地址，電子郵件
 */

public class SensitiveDataProcessUtils {
    /**
     * 中文姓名(顯示姓氏第一個及最後一個中文字，單名者顯示姓氏，其他以星號遮蔽)
     * Chinese Name
     * Display the first and last Chinese characters of the surname, display the surname for single names, and mask the rest with asterisks
     * @param chineseName 中文姓名 (Chinese Name)
     * @return 處理後的中文姓名 (Processed Chinese Name)
     */
    public static String processChineseName(String chineseName) {
        // 空值或空字串，直接回傳空字串
        if (chineseName == null || chineseName.length() == 0) {
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

    public static String processEnglishName(String englishName) {
        return null;
    }
}
