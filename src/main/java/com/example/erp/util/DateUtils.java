package com.example.erp.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author qzp
 * @date 2020/3/26
 */
public class DateUtils {
    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Date getMonthBegin(Date date){
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.set(Calendar.DAY_OF_MONTH,1);
        instance.set(Calendar.HOUR_OF_DAY,0);
        instance.set(Calendar.MINUTE,0);
        instance.set(Calendar.SECOND,0);
        instance.set(Calendar.MILLISECOND,0);
        return instance.getTime();
    }

    public static Date getMonthEnd(Date date){
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.set(Calendar.DAY_OF_MONTH,instance.getActualMaximum(Calendar.DAY_OF_MONTH));
        instance.set(Calendar.HOUR_OF_DAY,23);
        instance.set(Calendar.MINUTE,59);
        instance.set(Calendar.SECOND,59);
        instance.set(Calendar.MILLISECOND,999);
        return instance.getTime();
    }

    public static Date getLastMonth(Date date){
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        int month = instance.get(Calendar.MONTH);
        instance.set(Calendar.MONTH,month-1);
        return instance.getTime();
    }


    /*获取日期间间隔多少天*/
    public static int daysBetween(Date date1,Date date2) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        long time1 = cal.getTimeInMillis();
        cal.setTime(date2);
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);
        return Integer.parseInt(String.valueOf(between_days));
    }


    /*根据生日计算年龄*/
    public static int getAge(Date date) {
        Calendar cal = Calendar.getInstance();
        if (cal.before(date)) {
            throw new IllegalArgumentException("输入的生日应小于当前时间");
        }
        int yearNow = cal.get(Calendar.YEAR);  //当前年份
        int monthNow = cal.get(Calendar.MONTH);  //当前月份
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH); //当前日期
        cal.setTime(date);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
        int age = yearNow - yearBirth;   //计算整岁数
        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) age--;//当前日期在生日之前，年龄减一
            } else {
                age--;//当前月份在生日之前，年龄减1
            }
        }
        return age;
    }

    /*根据生日年份计算年龄*/
    public static int getAge(Integer yearsBirth){
        Calendar cal = Calendar.getInstance();
        int yearNow = cal.get(Calendar.YEAR);  //当前年份
        int age = yearNow - yearsBirth;
        if (age < 1) {
            throw new IllegalArgumentException("输入的生日应小于当前年份");
        }
        return age;
    }
}
