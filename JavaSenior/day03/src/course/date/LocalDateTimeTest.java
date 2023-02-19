package course.date;

import java.time.*;

/**
 * 第三代日期类使用
 *      localDate
 *      localTime
 *      localDateTime(最常用)
 * @author muchen
 * @create 2022 - 09 - 2022/9/18 16:41
 */
public class LocalDateTimeTest {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();      //输出当前日期
        LocalTime localTime = LocalTime.now();      //输出当前时间24小时格式
        LocalDateTime localDateTime = LocalDateTime.now();      //输出当前日期和时间

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //of()--设置指定的年月日时分秒，并且没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2022, 9, 17, 17, 01, 48);
        System.out.println(localDateTime1);

        System.out.println("年：" + localDateTime.getYear());
        System.out.println("月：" + localDateTime.getMonth());//返回英语的月份
        System.out.println("月：" + localDateTime.getMonthValue());//返回数字式的月份
        System.out.println("日：" + localDateTime.getDayOfMonth());
        System.out.println("时：" + localDateTime.getHour());
        System.out.println("分：" + localDateTime.getMinute());
        System.out.println("秒：" + localDateTime.getSecond());


        //第三代日期类中instant（时间戳）的使用
        //now()--获取本初子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println("本初子午线标准时间" + instant);

        //添加偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println("东八区时间" + offsetDateTime);

        //获取自1970年1月1日0时0分0秒至今的毫秒数
        long l = instant.toEpochMilli();
        System.out.println(l);
    }
}
