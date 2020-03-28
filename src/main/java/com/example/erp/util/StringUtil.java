package com.example.erp.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author qzp
 * @date 2020/3/27
 */
public class StringUtil {
    private static Pattern humpPattern = Pattern.compile("[A-Z]");
    /** 驼峰转下划线 */
    public static String humpToLine(String str) {
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
}
