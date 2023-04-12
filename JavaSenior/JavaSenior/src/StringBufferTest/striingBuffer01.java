package StringBufferTest;

import java.util.Scanner;

/**
 * String:不可变字符序列，不适用于String变化较多的地方，效率低，但是复用性高
 * 结论：如果我们对String做大量修改，不要用String
 *
 * StringBuffer:可变字符序列，效率较高，线程安全
 * StringBuilder:可变字符序列，效率最高，线程不安全，适用于单线程
 *
 * 输入一个带小数点的数按照该格式输入出来 ：41,142,241,354.1414;
 * 输入：1234567.89
 * 输出：1,234,567.89
 * @author muchen
 * @create 2022 - 09 - 2022/9/11 22:20
 */
public class striingBuffer01 {
    public static void main(String[] args) {
//        StringBuffer
        System.out.println("请输入一个带小数点的数：");
        String s1 = new Scanner(System.in).next();
        System.out.println(s1);
        StringBuffer stringBuffer1 = new StringBuffer(s1);  //将其转为stringBuffer 调用其特有的方法；
//        System.out.println(s1.toUpperCase());
//        int s = stringBuffer1.lastIndexOf(".");
        for (int i = stringBuffer1.lastIndexOf(".") - 3;i > 0;i -= 3){
            stringBuffer1 = stringBuffer1.insert(i,",");
        }
        System.out.println(stringBuffer1);
    }
}
