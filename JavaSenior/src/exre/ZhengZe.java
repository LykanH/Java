package exre;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author muchen
 * @create 2022 - 09 - 2022/9/19 16:09
 */
public class ZhengZe {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();
        Pattern pattern = Pattern.compile("1[3|8][6|3|8][1-9]{8}");
        boolean b1 = str1.matches("1[3|8][6|3|8][1-9]{8}");
        if (b1 == true) {
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}
