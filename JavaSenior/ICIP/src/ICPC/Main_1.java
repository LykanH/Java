package ICPC;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author muchen
 * @create 2023 - 04 - 2023/4/10 19:54
 */

/**
 * 韩信点兵
 * 1<=N<=100
 * 各个武力值<=1000
 */
public class Main_1 {
    static int N = 110;
    static int res;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int N = scanner.nextInt();
        for(int i = 0;i < N;i++){
            res += scanner.nextInt();
        }
        System.out.println(res*2);
    }
}
