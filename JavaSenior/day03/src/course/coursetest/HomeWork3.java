package course.coursetest;

import java.util.Scanner;

/**
 * @author muchen
 * @create 2022 - 09 - 2022/9/20 19:46
 * 编写Java程序，输入形式为：的人名，以 Ping,Han,S 的形式打印出来，其中S中间单词的首字母
 */
public class HomeWork3 {
    public static void main(String[] args) {
        System.out.println("请输入字符串");
        String st1 = new Scanner(System.in).nextLine();
//        LocalDateTime l1 = LocalDateTime.now();
//        System.out.println(l1.getDayOfYear());
//        System.out.println(System.currentTimeMillis());
//        st1 = null;
        String[] strings;
        if (st1 == null) {
            System.out.println("字符串不能为空!");
            return;
        } else {
            if(!(st1.matches("[A-Z][A-z]{1,5}[ ][A-Z][A-z]{1,5}[ ][A-Z][A-z]{1,5}"))){
                System.out.println("输入的不符合题目要求！");
                return;
            }else {
                strings = st1.split(" ");//使用空格来分割该字符串，返回值为String数组
            }
//        System.out.println(strings[0]);
//        System.out.println();
            System.out.println(strings[2] + "," + strings[0] + "," + strings[1].toUpperCase().charAt(0));
        }
    }
}