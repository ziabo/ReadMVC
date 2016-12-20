package com.ziabo.ziabo.readmvc.utils;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串有关的utils
 */
public class StringUtil {

    // 判断字符串的合法性
    public static boolean checkStr(String str) {
        if (null == str) {
            return false;
        }
        if ("".equals(str)) {
            return false;
        }
        if ("".equals(str.trim())) {
            return false;
        }
        if ("null".equals(str)) {
            return false;
        }
        return true;
    }


    // 判断密码格式是否正确 6-13位
    public static boolean isPassword(String password) {
        return password.length() >= 6 || password.length() <= 13;
    }


    /**
     * 验证字符串是否为空
     */
    public static boolean empty(String param) {
        return param == null || param.trim().length() < 1;
    }


    /**
     * 验证手机号码
     */
    public static boolean isPhone(String phone) {
        if (!checkStr(phone)) {
            return false;
        }
        String pattern = "^1[3|4|5|7|8][0-9]{9}$";
        return phone.matches(pattern);
    }

    /**
     * 判断是否是身份证
     */

    public static boolean isIDCardNum(String IDCards) {

        Pattern p = Pattern
                .compile("((11|12|13|14|15|21|22|23|31|32|33|34|35|36|37|41|42|43|44|45|46|50|51|52|53|54|61|62|63|64|65)[0-9]{4})" +
                        "(([1|2][0-9]{3}[0|1][0-9][0-3][0-9][0-9]{3}" +
                        "[Xx0-9])|([0-9]{2}[0|1][0-9][0-3][0-9][0-9]{3}))");
        Matcher m = p.matcher(IDCards);
        return m.matches();
    }

}
