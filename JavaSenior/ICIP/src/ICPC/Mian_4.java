package ICPC;

/**
 * @author muchen
 * @create 2023 - 04 - 2023/4/10 20:28
 */

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 姬昌学射
 * 1<N<100 (边长)     0=<M<=N*N(jichang射击次数)
 * (a,b) 视图面的两个坐标值
 */
public class Mian_4 {

    static LinkedList<Pii> data = new LinkedList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for(int k=1;k<=N;k++)
        for(int i=k;i<=k;i++)   for(int j=1;j<=N;j++) System.out.println(i+" "+j);
//        for(int i=1;i<=N;i++)    for(int j=i;j<=N;j++)    for(int k=1;k<=N;k++) System.out.println(j+" "+k);
    }
}

class Pii{
    int x;
    int y;

    public Pii(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
