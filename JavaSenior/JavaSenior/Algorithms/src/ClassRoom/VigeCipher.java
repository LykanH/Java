package ClassRoom;

import java.util.Scanner;

/**
 * @author muchen
 * @create 2022 - 10 - 2022/10/8 20:35
 * <p>
 * 维吉尼亚密码加密明文
 */
public class VigeCipher {
    public static void main(String[] args) {
        //从键盘输入明文，并将明文从字符串类型转化为char数组类型，同时输入明文加密对应的密钥，
        //代码中存在简单的判断，如果明文和密钥的长度不一致，则终止程序，并报错。否则，对铭文
        // 进行维吉尼亚密码的加密。
        System.out.print("请输入明文：");
        char[] plaintext = new Scanner(System.in).nextLine().toCharArray();
        System.out.println("请输入与明文同样长度的密钥：");
        char[] key = new Scanner(System.in).nextLine().toCharArray();
        if (plaintext.length != key.length) {
            System.out.println("明文与密钥长度不一致，请重新运行！");
            return;
        }
        //定义新的数组来存放密文
        char[] cipher = new char[plaintext.length];
        //核心代码，通过取出明文和密钥中相对应位置上的字符，再从密钥和明文的二维表中，两个字符
        //交汇点为密文。密文的不同取决于密钥，即任何明文都可以被加密成任何一个字母。
        for (int i = 0; i < plaintext.length; i++) {
            cipher[i] = (char) ((plaintext[i] - 'a' + key[i] - 'a') % 25 + 'a');
        }
        System.out.println("密文为：" + new String(cipher));
    }
}
