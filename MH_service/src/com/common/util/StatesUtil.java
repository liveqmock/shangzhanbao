package com.common.util;

/**
 * @author 何大勇
 * @date 2013-9-2
 */
public class StatesUtil {
    /**
     * 从数字判断状态集(用于状态字段为int的时候，查询多个状态的选择情况)
     * 
     * @return String
     * @throws
     * @2013-9-2 上午11:37:27
     * @author 何大勇
     */
    public static String getStateSetByNumber(int number) {
        if (number < 1) {
            return "";
        }
        String result = "";
        for (int i = 0; number > 0;) {
            int a = (int) Math.pow(2, i);
            if (a * 2 > number) {
                result += "," + (i);
                number -= a;
                i = 0;
            } else {
                i++;
            }
        }
        return result.substring(1);
    }

    /**
     * @author 何大勇
     * @date 2013-9-2
     * @update
     * @return
     */
    public static Integer getNumberFromArray(String[] strs) {
        Double double1 = 0.00;
        for (int i = 0; i < strs.length; i++) {
            double1 += Math.pow(2, new Integer(strs[i]));
        }
        return double1.intValue();
    }
}
