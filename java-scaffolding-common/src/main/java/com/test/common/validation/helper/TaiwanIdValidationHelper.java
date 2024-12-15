package com.test.common.validation.helper;

import com.test.common.constants.TaiwanIdConstants;
import com.test.common.utils.StringUtils;

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
     * 新增檢查性別是否正確 (字母後的數字是否為1/2 -> 1: 男性 / 2: 女性)
     * @param id
     * @return true (正確) / false (錯誤)
     */
    public static boolean isValidTaiwanId(String id) {
        try {
            if (isValidTaiwanIdFormat(id)) {
                int areaNumber = TaiwanIdConstants.areaMap.get(id.toUpperCase().charAt(0));
                String idNumber = String.valueOf(areaNumber) + id.substring(1);
                return checkSum(idNumber, TaiwanIdConstants.TAIWAN_ID_LOGIC_MULTIPLIERS, 0);
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    /**
     * 檢查輸入是否為有效的台灣身分證字號 (E.G: B120667503)
     *
     * @param input 以轉換的身分證字號
     * @param multiplier 乘數
     * @param remainder 餘數
     * @return true (正確) / false (錯誤)
     */
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

    /**
     * 檢查輸入是否為有效的公司統一編號 (E.G: 12345678)
     * 統一編號第7位數非"7":
     * 1. 統一編號 * 公司統一編號邏輯乘數
     * 2. 將乘積的十位數和個位數相加
     * 3. 總和除以10，若餘數為0，則為正確
     *
     * 統一編號倒數第二位為7時，乘積之和最後第二位數取0，或1均可，其中之一
     * 『和』能被10整除，則表示該公司統一編號為正確，否則為錯誤。
     * @param id 公司統一編號
     * @return true (正確) / false (錯誤)
     */
    public static boolean isValidTaiwanCompanyId(String id) {
        try {
            if (isValidCompanyIdFormat(id)) {
                int sum = 0;
                for (int index = 0; index < TaiwanIdConstants.TAIWAN_COMPANY_LOGIC_MULTIPLIERS.length; index++) {
                    int multiplyResult = Integer.parseInt(id.substring(index, index + 1)) * TaiwanIdConstants.TAIWAN_COMPANY_LOGIC_MULTIPLIERS[index];
                    int additionResult = ((multiplyResult / 10) + (multiplyResult % 10));
                    sum += additionResult;
                }

                if (sum % 10 == 0) {
                    return true;
                } else if ("7".equals(id.substring(6, 7))) {
                    if ((sum + 1) % 10 == 0) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 檢查輸入是否為有效的台灣身分證字號格式 (E.G: B120667503)
     * 固定長度為10碼，且符合正規表示式
     *
     * @param id
     * @return true (正確) / false (錯誤)
     */
    public static boolean isValidTaiwanIdFormat(String id) {
        return StringUtils.length(id) == 10 && TaiwanIdConstants.TAIWAN_ID_PATTERN.matcher(id).matches() && (id.charAt(1) == '1' || id.charAt(1) == '2');
    }

    /**
     * 檢查輸入是否為有效的公司統一編號格式 (E.G: 12345678)
     *
     * @param id 公司統一編號
     * @return true (正確) / false (錯誤)
     */
    public static boolean isValidCompanyIdFormat(String id) {
        return StringUtils.length(id) == 8 && TaiwanIdConstants.TAIWAN_COMPANY_PATTERN.matcher(id).matches();
    }
}
