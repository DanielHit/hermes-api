package com.qiezi.hermes.api.utils;

import java.util.Calendar;
import java.util.Date;

public class DateFormatUtils {

    // 转换到查找的天数之前的截止时间,如3天前返回
    public static String formatDateByDays(int days) {
        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateResult = dayAddAndSub(Calendar.DATE, 0 - days);
        return sdf.format(dateResult);
    }

    public static Date dayAddAndSub(int currentDay, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(currentDay, day);
        Date startDate = calendar.getTime();
        return startDate;
    }


}
