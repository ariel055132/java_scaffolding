package com.test.common.sensitive.enums;

/**
 * 自定義敏感資料處理共用類型
 * Custom sensitive data processing common type
 * 包含 中文姓名，英文姓名，出生年月日，身分證字號，電話號碼，行動電話，中文地址，英文地址，電子郵件
 * Include Chinese Name, English Name, Birth Date, ID Number, Phone Number, Cell Phone Number, Chinese Address, English Address, Email
 */

public enum DesensitizeType {
    /**
     * 中文姓名
     */
    CHINESE_NAME,
    /**
     * 英文姓名
     */
    ENGLISH_NAME,
    /**
     * 出生年月日
     */
    BIRTH_DATE,
    /**
     * 身分證字號
     */
    ID_NUMBER,
    /**
     * 電話號碼
     */
    PHONE_NUMBER,
    /**
     * 行動電話
     */
    CELL_PHONE_NUMBER,
    /**
     * 中文地址
     */
    CHINESE_ADDRESS,
    /**
     * 英文地址
     */
    ENGLISH_ADDRESS,
    /**
     * 電子郵件
     */
    EMAIL,
    /**
     * 自定義 Rule
     */
    CUSTOM_RULE
}
