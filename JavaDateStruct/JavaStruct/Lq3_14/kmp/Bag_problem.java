package kmp;

import java.util.Iterator;
import java.util.Scanner;

/**
 * 01背包问题动态规划实现。因为如果使用递归解法时间复杂度为指数
 * 
 * @author LykanHyper
 *
 *         有 N 件物品和一个容量是 V 的背包。每件物品只能使用一次。
 * 
 *         第 i 件物品的体积是 vi ，价值是 wi 。
 * 
 *         求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。 输出最大价值。
 * 
 *         输入格式 第一行两个整数，N，V ，用空格隔开，分别表示物品数量和背包容积。
 * 
 *         接下来有 N 行，每行两个整数 vi,wi ，用空格隔开，分别表示第 i 件物品的体积和价值。
 * 
 *         输出格式 输出一个整数，表示最大价值。
 */
public class Bag_problem {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();//物品数量
		int V = scanner.nextInt();//背包容积
		int[][] dp = new int[N][V+1];//定义dp数组
		int[] v = new int[N];//物品体积
		int[] w = new int[N];//物品价值
		for(int i = 0;i < N;i++) {
			v[i] = scanner.nextInt();
			w[i] = scanner.nextInt();
		}
		for(int j=v[0];j<V;j++) {
			dp[0][j] = w[0];
		}
		for(int i = 1;i < N;i++) {
			for(int j = 1;j <= V;j++) {
				if(j<v[i]) {
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-v[i]]+w[i]);
				}
			}
		}
		System.out.println(dp[N-1][V]);
	}

}
