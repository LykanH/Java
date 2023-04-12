package course.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author muchen
 * @create 2022 - 09 - 2022/9/17 13:38
 */
public class Date01 {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println("当前时间：" + date);     //输出格式是国外的时间格式

        //将其转换为国内的日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh：mm：ss E");
        String formate = sdf.format(date);

        System.out.println("当前日期为：" + formate);

    }
}
