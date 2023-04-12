package course.date;

import java.util.Calendar;

/**
 * @author muchen
 * @create 2022 - 09 - 2022/9/17 14:14
 */
public class Calendar_ {
    public static void main(String[] args) {
        Calendar c1 = Calendar.getInstance();       //Calendar中的构造器是私有化的 必须通过Calendar中的
        //getInstance 方法来实例化对象
        System.out.println("年：" + c1.get(Calendar.YEAR));
        System.out.println("月" + (c1.get(Calendar.MONTH) + 1));
        System.out.println("日" + c1.get(Calendar.DAY_OF_MONTH));
        System.out.println("时" + c1.get(Calendar.HOUR));
        System.out.println("分" + c1.get(Calendar.MINUTE));
        System.out.println("秒" + c1.get(Calendar.SECOND));

        System.out.println(c1.get(Calendar.YEAR) + "年" + c1.get(Calendar.MONTH) + "月" + c1.get(Calendar.DAY_OF_MONTH)
                + " " + c1.get(Calendar.HOUR) + ":" + c1.get(Calendar.MINUTE) + ":" + c1.get(Calendar.SECOND));
        //按照12小时输出当前时间

        System.out.println(c1.get(Calendar.YEAR) + "年" + c1.get(Calendar.MONTH) + "月" + c1.get(Calendar.DAY_OF_MONTH)
                + " " + c1.get(Calendar.HOUR_OF_DAY) + ":" + c1.get(Calendar.MINUTE) + ":" + c1.get(Calendar.SECOND));
        //按照24小时输出当前时间
    }
}
