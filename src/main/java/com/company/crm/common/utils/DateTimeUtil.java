package com.company.crm.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zytwl
 */
public class DateTimeUtil {

    public static String getSystemTime(){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = format.format(date);
        return dateStr;
    }

    public static String convertToString(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = format.format(date);
        return dateStr;
    }
}
