package com.tjpu.java.Date_DateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeDemo {
    public static void main(String[] args) {
        //获取本地的时间
        LocalDate now = LocalDate.now();
        System.out.println("本地的时间是："+now);

        //获取本地的时间并且指定时间的格式“yyyy-mm-ddd HH:mm:ss”
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("本地的时间格式化: " + localDateTime.format(dtf));
        System.out.println("年份: " + localDateTime.getYear());
        System.out.println("当前年份中第多少天(1-365 or 1-366): " + localDateTime.getDayOfYear());
        System.out.println("英文表示月份: " + localDateTime.getMonth());
        System.out.println("以数字的方式表示月份(1-12): " + localDateTime.getMonthValue());
        System.out.println("当前月份中第几天(1-31): " + localDateTime.getDayOfMonth());
        System.out.println("星期几: " + localDateTime.getDayOfWeek());
        System.out.println("小时: " + localDateTime.getHour());
        System.out.println("分钟: " + localDateTime.getMinute());
        System.out.println("秒: " + localDateTime.getSecond());
        // 指定日期
        LocalDateTime ldt = LocalDateTime.of(2020, 1, 26, 8, 30, 30);
        // 获取年月日
        System.out.println(ldt.toLocalDate());
        // 获取时分秒
        System.out.println(ldt.toLocalTime());

    }
}
