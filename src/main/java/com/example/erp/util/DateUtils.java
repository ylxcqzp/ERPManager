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
}
