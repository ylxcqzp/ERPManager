package com.example.erp.util;

import org.springframework.util.DigestUtils;

/**
 * @author qzp
 * @date 2020/4/14
 */
public final class MD5Util {
    private static final String SALT = "ghost";
    //生成md5加密后的密码
    public static String encode(String password){
        String s = addSalt(password, SALT);
        return DigestUtils.md5DigestAsHex(s.getBytes());
    }
    //将salt于密码进行拼接,让密码更加复杂
    private static String addSalt(String password,String salt) {
        return salt.charAt(0) + password + salt;
    }
}
