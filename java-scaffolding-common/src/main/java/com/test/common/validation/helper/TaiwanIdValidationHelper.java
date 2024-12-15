package com.test.common.validation.helper;

import com.test.common.constants.TaiwanIdConstants;

public class TaiwanIdValidationHelper {
    public TaiwanIdValidationHelper () {
    }

    /**
     * 檢查輸入是否為有效的台灣身分證字號 (E.G: B120667503)
     * 字母(ABCDEFGHJKLMNPQRSTUVXYWZIO)對應一組數(10~35)，
     * 令其十位數為X1，個位數為X2；( 如Ａ：X1=1 , X2=0 )；D表示2~9數字
     * Y = X1 + 9*X2 + 8*D1 + 7*D2 + 6*D3 + 5*D4 + 4*D5 + 3*D6 + 2*D7+ 1*D8 + D9
     * 如Y能被10整除，則表示該身分證號碼為正確，否則為錯誤。
     *
     * @param id
     * @return true (正確) / false (錯誤)
     */
    public static boolean isValidTaiwanId(String id) {
        try {
            if (TaiwanIdConstants.TAIWAN_ID_PATTERN.matcher(id.toUpperCase()).matches()) {
                int areaNumber = TaiwanIdConstants.areaMap.get(id.toUpperCase().charAt(0));
                String idNumber = String.valueOf(areaNumber) + id.substring(1);
                return checkSum(idNumber, TaiwanIdConstants.TAIWAN_ID_LOGIC_MULTIPLIERS, 0);
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    private static boolean checkSum(String input, int[] multiplier, int remainder) {
        if (input == null || multiplier == null || input.length() != multiplier.length) {
            return false;
        }
        int sum = 0;
        for (int index = 0; index < input.length(); index++) {
            sum += Character.getNumericValue(input.charAt(index)) * multiplier[index];
        }
        return sum % 10 == remainder;
    }

    public static boolean isValidForeignerTaiwanId(String id) {
        return true;
    }

    public static boolean isValidCompanyTaiwanId(String id) {
        return true;
    }
}
