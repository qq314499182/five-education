package com.five.fiveeducation.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {

    // 获取下一周的日期
    public static Date nextWeek(Date currentDate) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(currentDate);
        cal.add(GregorianCalendar.DATE, 7);// 在日期上加7天
        return cal.getTime();
    }

    // 获取本周日的日期
    public static Date getSunday(Date monday) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(monday);
        cal.add(GregorianCalendar.DATE, 6);// 在日期上加6天
        return cal.getTime();
    }

    // 获取下一月的日期
    public Date nextMonth(Date currentDate) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(currentDate);
        cal.add(GregorianCalendar.MONTH, 1);// 在月份上加1
        return cal.getTime();
    }

    // 获取下一年的日期
    public Date nextYear(Date currentDate) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(currentDate);
        cal.add(GregorianCalendar.YEAR, 1);// 在年上加1
        return cal.getTime();
    }

    /**
     * @param date
     * @return
     * @作者 王建明
     * @创建日期 2013-06-06
     * @创建时间 10:47:36
     * @描述 —— 获取日期为该月的第几周
     */
    public static int getWeekInMonthNum(Date date) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        int week = cal.get(Calendar.WEEK_OF_MONTH);// 获取是本月的第几周
        return week;
    }


    /**
     * @return
     * @作者 王建明
     * @创建日期 2013-01-24
     * @创建时间 08:53:51
     * @描述 —— 获取本月第一天
     */
    public static String firstDayOfMonth() {
        Calendar cal = Calendar.getInstance();

        SimpleDateFormat datef = new SimpleDateFormat("yyyy-MM-dd");
        cal.set(Calendar.DATE, 1);
        cal.roll(Calendar.DATE, -1);
        // 当前月的第一天
        cal.set(GregorianCalendar.DAY_OF_MONTH, 1);
        Date beginTime = cal.getTime();
        String beginTime1 = datef.format(beginTime) + " 00:00:00";
        return beginTime1;
    }

    /**
     * @return
     * @作者 王建明
     * @创建日期 2013-01-24
     * @创建时间 08:54:06
     * @描述 —— 获取本月最后一天
     */
    public static String lastDayOfMonth() {
        Calendar cal = Calendar.getInstance();

        SimpleDateFormat datef = new SimpleDateFormat("yyyy-MM-dd");
        // 当前月的最后一天
        cal.set(Calendar.DATE, 1);
        cal.roll(Calendar.DATE, -1);
        Date endTime = cal.getTime();
        String endTime1 = datef.format(endTime) + " 23:59:59";
        return endTime1;
    }

    /**
     * @return
     * @作者 王建明
     * @创建日期 2013-05-22
     * @创建时间 09:48:04
     * @描述 —— 获取当前星期数字
     */
    public static int getNowWeekNum() {
        int weekDay = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        return weekDay == 1 ? 7 : weekDay - 1;
    }

    // 获得当前日期与本周一相差的天数
    private static int getMondayPlus() {
        Calendar cd = Calendar.getInstance();
        // 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == 1) {
            return -6;
        } else {
            return 2 - dayOfWeek;
        }
    }

    /**
     * @param currentDate
     * @param num
     * @return
     * @作者 王建明
     * @创建日期 2013-6-8
     * @创建时间 下午2:44:24
     * @描述 —— 获取与指定日期距离num天的日期
     */
    public static Date getDateFromSourceDate(Date currentDate, int num) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(currentDate);
        cal.add(GregorianCalendar.DATE, num);
        return cal.getTime();
    }

    /**
     * @param date1
     * @param date2
     * @return
     * @作者 王建明
     * @创建日期 2013-06-20
     * @创建时间 14:08:37
     * @描述 —— 计算两个日期相隔多少天
     */
    public static long differ(Date date1, Date date2) {
        Long differLong = date2.getTime() / 86400000 - date1.getTime()
                / 86400000; // 用立即数，减少乘法计算的开销
        return Math.abs(differLong);
    }
}
