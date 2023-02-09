package com.example.springbooot.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternUtil {
    //密码正则:大写字母+小写字母+数字+下划线的组合
    public static boolean isPassword(String password) {
        String regex = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[_]).{8,}$";
        Pattern p = Pattern.compile ( regex, Pattern.CASE_INSENSITIVE );
        Matcher m = p.matcher ( password );
        return m.matches ();
    }
}
