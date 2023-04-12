package ICPC;

/**
 * @author muchen
 * @create 2023 - 04 - 2023/4/10 20:10
 */

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 孔融让梨
 * First Line: T and N (T:case N:children)
 * sec: 输入T行每行N个数据  且每个数据<=1000
 * 1<=T<=100    1<=N<=1000
 */
public class Main_3 {
    static int S = 1010;
    static int[][] data = new int[S][S];
    static int T,N;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        T = scanner.nextInt();
        N = scanner.nextInt();
        for(int i=0;i<T;i++) {
            for (int j = 0; j < N; j++) {
                data[i][j] = scanner.nextInt();
            }
        }
        for(int i=0;i<T;i++) System.out.println(check(data[i]));
    }
    static public int check(int[] ints){
        int min_value = Integer.MAX_VALUE;
        for (int i = 0;i< N;i++){
            min_value = min_value < ints[i] ? min_value:ints[i];
        }
        return min_value;
    }
}
