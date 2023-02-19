package ClassRoom;

import java.util.Scanner;

/**
 * @author muchen
 * @create 2022 - 10 - 2022/10/8 16:32
 * <p>
 * 仿射密码
 */
public class AffineCipher {
    public static void main(String[] args) {
        //仿射密码加密通过两个常数和明文对应字符的一次方程，进行加密。程序首先使用户输入两个整数，
        // 这两个整数互素，并且中间用空格隔开，然后将用户输入的两个值分别赋给num1和num2。然后让
        //用户输入明文字符串，然后将字符串转化为char类型的数组进行保存，然后调用加密类和类中的
        //方法，通过返回值返回加密后的密文。
        System.out.print("输入想通过哪两个互素的数对明文进行加密中间用空格隔开：");
        String s1 = new Scanner(System.in).nextLine();
        String[] split = s1.split(" ");
        int num1 = Integer.parseInt(split[0]);
        int num2 = Integer.parseInt(split[1]);
        System.out.print("请输入明文：");
        char[] chars = new Scanner(System.in).nextLine().toCharArray();
        System.out.println("经过仿射加密后密文为：" + new Affine(num1,num2,chars).cipher());
    }
}

class Affine {
    int num1, num2;
    char[] chars;

    public Affine(int num1, int num2, char[] chars) {
        this.num1 = num1;
        this.num2 = num2;
        this.chars = chars;
    }

    public Affine() {
    }

    public Affine(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    //创建一个新的char类型数组用来存放加密后的明文，for循环通过main()中传入的两个整数，经过script[i] = chars[i]
    // >= 'a'?(char) ((num1 * (chars[i] - 'a') + num2) % 25 +'a'):(char) ((num1 * (chars[i] - 'A') + num2) % 25 +'A');
    // 以上加密式原理为：E(x) = (ax + b) mod 26
    public String cipher() {
        char[] script = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            script[i] = chars[i] >= 'a'?(char) ((num1 * (chars[i] - 'a') + num2) % 25 +'a'):(char) ((num1 * (chars[i] - 'A') + num2) % 25 +'A');
        }
//        System.out.println(Arrays.toString(script));
        return new String(script);
    }
}