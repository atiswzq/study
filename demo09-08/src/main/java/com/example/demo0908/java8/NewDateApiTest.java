package com.example.demo0908.java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @author kywzq
 * @ClassName NewDateApiTest.java
 * @Description 新版时间工具学习
 * @createTime 2022年09月14日 16:58:00
 */
public class NewDateApiTest {

    public static void main(String[] args) {
       /* // 旧的方式，可以new
        Date date = new Date();
        System.out.println("old api" + date);

        // 新的方式，只能通过给定的方法获取
        LocalDate newDate = LocalDate.now(); 			 // 日期 2020-12-12
        LocalTime newTime = LocalTime.now(); 			 // 时间 16:30:00:000
        LocalDateTime newDateTime = LocalDateTime.now(); // 日期+时间 2020-12-12T16:30:00.000
        System.out.println("newDate" + newDate);
        System.out.println("newTime" + newTime);
        System.out.println("newDateTime" + newDateTime);

        // 还可以组合哟
        LocalDateTime combineDateTime = LocalDateTime.of(newDate, newTime);
        System.out.println("combineDateTime" + combineDateTime);

        // 创建指定时间
        LocalDate customDate = LocalDate.of(2020, 11, 5);
        LocalTime customTime = LocalTime.of(16, 30, 0);
        LocalDateTime customDateTime = LocalDateTime.of(2020, 11, 5, 16, 30, 0);
        System.out.println("customDate" + customDate);
        System.out.println("customTime" + customTime);
        System.out.println("customDateTime" + customDateTime);*/



       /* // 获取时间参数的年、月、日（有时需求要用到）
        System.out.println("获取时间参数的年、月、日：");
        LocalDateTime param = LocalDateTime.now();
        System.out.println("year:" + param.getYear());
        System.out.println("month:" + param.getMonth());
        System.out.println("day:" + param.getDayOfMonth());
        System.out.println("hour:" + param.getHour());
        System.out.println("minute:" + param.getMinute());
        System.out.println("second:" + param.getSecond() + "\n");

        // 计算昨天的同一时刻（由于对象不可修改，所以返回的是新对象）
        System.out.println("计算前一天的当前时刻：");
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime yesterday = today.minus(1, ChronoUnit.DAYS);
        System.out.println("today:" + today);
        System.out.println("yesterday:" + yesterday);
        System.out.println("same object:" + today.equals(yesterday) + "\n");

        // 计算当天的00点和24点（你看，这里就看到组合的威力了）
        System.out.println("计算当天的00点和24点：");
        LocalDateTime todayBegin = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        LocalDateTime todayEnd = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        System.out.println("todayBegin:" + todayBegin);
        System.out.println("todayEnd:" + todayEnd + "\n");

        System.out.println("计算一周、一个月、一年前的当前时刻：");
        LocalDateTime oneWeekAgo = today.minus(1, ChronoUnit.WEEKS);
        LocalDateTime oneMonthAgo = today.minus(1, ChronoUnit.MONTHS);
        LocalDateTime oneYearAgo = today.minus(1, ChronoUnit.YEARS);
        System.out.println("oneWeekAgo" + oneWeekAgo);
        System.out.println("oneMonthAgo" + oneMonthAgo);
        System.out.println("oneYearAgo" + oneYearAgo + "\n");*/

        LocalDateTime now = LocalDateTime.now();
        System.out.println("格式化前:" + now);
        String format = now.format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println("默认格式:" + format);
        String other = now.format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("其他格式:" + other);
    }
}
