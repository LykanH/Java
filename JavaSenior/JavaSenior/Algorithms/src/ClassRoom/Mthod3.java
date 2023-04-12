package ClassRoom;

import java.util.Scanner;

/**
 * @author muchen
 * @create 2022 - 09 - 2022/9/19 21:03
 */
public class Mthod3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入带加密的明文：");
        String plaintexts = sc.nextLine();
        int len = plaintexts.length() % 7 == 0 ? plaintexts.length() / 7 : (plaintexts.length() / 7) + 1;//定义二维数组是要用到，主要作用是确定二维数组中一维数组的个数
        char[] plaintext_char = new char[7 * len];//先将明文存入一维数组中，在后面再将其存入二维数组中
        char[][] arr = new char[len][7];//存放明文和解密后的明文的二维数组
        char[][] miwen = new char[len][7];//存放密文的二维数组
        char[] n = new char[7];//在解密过程中用来消掉多余的填充的0
        int[] key = {6, 3, 0, 4, 1, 5, 2};//加密秘钥
        int[] transkey = {2, 4, 6, 1, 3, 5, 0};//解密秘钥

        fill(plaintexts, plaintext_char, len, arr);
        encryption(len, miwen, arr, key);
        System.out.println("加密后的明文是：");
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < miwen[i].length; j++) {
                System.out.print(miwen[i][j]);
            }
        }//输出密文
        System.out.println(" ");
        System.out.println("按下1解密或按其他任意键退出：");
        String a = sc.nextLine();
        if (a.equals("1")) {
//            decryption(n, len, miwen, arr, transkey, plaintexts);
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(arr[i][j]);
                }
            }
        } else {
            System.out.println("退出！");
        }//输出明文或退出
    }

    private static void encryption(int len, char[][] miwen, char[][] arr, int[] key) {
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 7; j++) {
                miwen[i][j] = arr[i][key[j]];
            }
        }
    }

    public static void fill(String plaintexts, char[] plaintext_char, int len, char[][] arr) {
        for (int i = 0; i < plaintexts.length(); i++) {
            plaintext_char[i] = plaintexts.charAt(i);
        }
        for (int i = 0; i < plaintext_char.length; i++) {
            if (plaintext_char[i] == '\u0000') {
                plaintext_char[i] = '0';
            }//将字符串数组中的空字符'\0'替换为0
            for (int m = 0; m < len; m++) {
                for (int j = m * 7, k = 0; j < 7 * (m + 1) && k < 7; j++, k++) {
                    arr[m][k] = plaintext_char[m];
                }
            }
        }
    }
}