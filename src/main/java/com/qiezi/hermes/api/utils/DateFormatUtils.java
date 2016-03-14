package com.qiezi.hermes.api.utils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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

    public static long getIntervalDays(String endDate) throws ParseException {
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
        java.util.Date parseEndDate = format.parse(endDate);
        System.out.println((new Date()).getTime());
        System.out.println(parseEndDate.getTime());
        long day = ((new Date()).getTime() - parseEndDate.getTime()) / (24 * 60 * 60 * 1000);
        return day;
    }

    // 报价查询
    public static void main(String[] args) throws ParseException {
        Date dt2 = new Date();
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:MM:SS");

        java.util.Date dt1 = format.parse("2016-02-12 10:54:54");
        Date startDate = dt1;           // Set start date
        Date endDate = new Date();      // Set end date

        long duration = endDate.getTime() - startDate.getTime();
        long diffInSeconds = TimeUnit.MILLISECONDS.toSeconds(duration);
        long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
        long diffInHours = TimeUnit.MILLISECONDS.toHours(duration);

        System.out.println(duration);

    }
}