package Test;

import java.util.Scanner;

/**
 * @author muchen
 * @create 2022 - 09 - 2022/9/4 17:09
 *
 *  辗转相除法：递归实现
 */
public class ZhanZhuan {
    public static void main(String[] args) {

//        String s1 = "34245df";
//        String s2 = "34245df";
//        s1.length();
//        boolean equals = s1.equals(s2);
//        char[] chars = s1.toCharArray();
//        System.out.println(chars.length);
//        Arrays.sort(chars);//不需要返回值

        ZhanZhuan z1 = new ZhanZhuan();
        Scanner scan = new Scanner(System.in);
        System.out.println("输入a：");
        int a = scan.nextInt();
        System.out.println("输入b");
        int b = scan.nextInt();
        System.out.println("辗转相除法求得最大公约数为：" + z1.gcd(a,b));
    }
    public int gcd(int a,int b){
        if(b == 0){
            return a;
        }
        return gcd(b,a % b);
    }
}
