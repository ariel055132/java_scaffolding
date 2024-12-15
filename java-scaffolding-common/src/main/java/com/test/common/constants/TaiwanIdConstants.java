package com.test.common.constants;

import java.util.HashMap;
import java.util.regex.Pattern;

public class TaiwanIdConstants {
    // 台灣身分證字號正則表達式
    public static final Pattern TAIWAN_ID_PATTERN = Pattern.compile("[A-Z][12]\\d{8}");

    // 台灣身分證字號邏輯乘數
    public static final int[] TAIWAN_ID_LOGIC_MULTIPLIERS = {1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1};

    // 台灣地區代碼對照表
    public static HashMap<Character, Integer> areaMap = new HashMap<>();

    static {
        areaMap.put('A', 10); // 臺北市
        areaMap.put('B', 11); // 臺中市
        areaMap.put('C', 12); // 基隆市
        areaMap.put('D', 13); // 臺南市
        areaMap.put('E', 14); // 高雄市
        areaMap.put('F', 15); // 新北市
        areaMap.put('G', 16); // 宜蘭縣
        areaMap.put('H', 17); // 桃園市
        areaMap.put('I', 34); // 嘉義市
        areaMap.put('J', 18); // 新竹縣
        areaMap.put('K', 19); // 苗栗縣
        areaMap.put('L', 20); // 臺中縣 (已於2010年12月25日停止賦配)
        areaMap.put('M', 21); // 南投縣
        areaMap.put('N', 22); // 彰化縣
        areaMap.put('O', 35); // 新竹市
        areaMap.put('P', 23); // 雲林縣
        areaMap.put('Q', 24); // 嘉義縣
        areaMap.put('R', 25); // 臺南縣 (已於2010年12月25日停止賦配)
        areaMap.put('S', 26); // 高雄縣 (已於2010年12月25日停止賦配)
        areaMap.put('T', 27); // 屏東縣
        areaMap.put('U', 28); // 花蓮縣
        areaMap.put('V', 29); // 臺東縣
        areaMap.put('W', 32); // 金門縣
        areaMap.put('X', 30); // 澎湖縣
        areaMap.put('Y', 31); // 陽明山管理局 (已於1974年1月1日停止賦配)
        areaMap.put('Z', 33); // 連江縣
    }
}
