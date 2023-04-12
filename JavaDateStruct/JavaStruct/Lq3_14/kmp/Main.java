package kmp;

import java.util.Scanner;

/**
 * 统计方形
	有一个 n✖m方格的棋盘，求其方格包含多少正方形、长方形（不包含正方形）。
 * @author LykanHyper
 *
 */
public class Main {
	public static void main(String[] args) {
		//算出所有的矩形（包括正方形的数量），最终用矩形减去正方形数量即为真正矩形数量
		Scanner scanner = new Scanner(System.in);
		long m = scanner.nextLong();
		long n = scanner.nextLong();
		//横长所有可能的边长有1+2+3+...+m种(纵向亦如此)   --> (m+1)*m/2
		//则矩形总个数为
		long sum = ((m+1)*m)/2 * ((n+1)*n)/2;
		long x = m;
		long y = n;
		//正方形即为
		long squ = 0L;
		for(int i = 1;i <= Math.min(m, n);i++) {
			squ += x*y;
			x--;
			y--;
		}
		//输出正方形个数&输出长方形个数
		System.out.println(squ+" "+(sum-squ));
	
		
		
		
		scanner.close();
	}
}
