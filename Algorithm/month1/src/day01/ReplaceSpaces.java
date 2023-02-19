package day01;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author muchen
 * @create 2022 - 11 - 2022/11/17 21:13
 * 请实现一个函数，把字符串中的每个空格替换成"%20"。
 * <p>
 * 数据范围
 * 0 ≤ 输入字符串的长度 ≤ 1000。
 * 注意输出字符串的长度可能大于 1000。
 * <p>
 * <p>
 * 样例
 * 输入："We are happy."
 * <p>
 * 输出："We%20are%20happy."
 */
public class ReplaceSpaces {
    public static void main(String[] args) {
        Queue<String> q = new ArrayDeque<>();
        q.add("213");

        //        Scanner scanner = new Scanner(System.in);
//        String s1 = scanner.next();
//        StringBuffer stringBuffer = new StringBuffer();
//        for(int i = 0;i < s1.length();i++){
//            if(s1.charAt(i) != ' '){
//                stringBuffer.append(s1.charAt(i));
//            }else {
//                stringBuffer.append("%20");
//            }
//        }
//        return stringBuffer.toString();

        int d = 1000, ans = 0;
        for (int i = 1; i <= d; i++)
            for (int j = 1; j <= d; j++)
                if (i * i + j * j <= d * d)
                    ans++;
        System.out.println(ans * 4);
//        Scanner in=new Scanner(System.in);
//        int num=0,r=1000;
//        for(int i=1;i<=1000;i++)//以第一象限为例，遍历方格的右上顶点
//            for(int j=1;j<=1000;j++)
//                if(i*i+j*j<=1000000)
//                    num++;
//        System.out.println(num*4);
    }

}
