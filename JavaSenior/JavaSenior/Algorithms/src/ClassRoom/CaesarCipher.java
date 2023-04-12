package ClassRoom;

import java.util.Scanner;

/**
 * @author muchen
 * @create 2022 - 10 - 2022/10/8 15:53
f                                           *
 * 凯撒密码
 */
public class CaesarCipher {
    public static void main(String[] args) {
        //从键盘录入明文，用户输入回车之后，将字符串转化为char型数组，同时调用匿名类Caesar，并传入明文，
        //再用匿名类调用函数，执行完函数之后进行输出。
        System.out.println("请输入一段明文：");
        String s1 = new Scanner(System.in).nextLine();
        char[] chars = s1.toCharArray();
        String sc = new Caesar(chars).cipher();
        System.out.println("密文为：" + sc);
    }
}

class Caesar {
    char[] chars;

    public Caesar(char[] chars) {
        this.chars = chars;
    }

    public Caesar() {
    }

    public String cipher() {
        //核心代码
        //创建一个新的char类型数组，存放密文，加密语句意思为：通过三元运算符判断字母为大写还是小写，判断之后
        //，按照输入的整数进行移位，对所对应位置上的字符减去a的ascal码值，再对25取模，最后加上a的ascal码，
        //结果就为凯撒密码的密文。
        System.out.println("输入需要移动的位数（整数）：");
        int num = new Scanner(System.in).nextInt();
        char[] chars1 = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            chars1[i] = chars[i] >= 'a' ? (char) ((chars[i] - 'a' + num) % 25 + 'a') : (char) ((chars[i] - 'A' + num) % 25 + 'A');
        }
        return new String(chars1);
    }
}
