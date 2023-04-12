package kmp;

import java.util.Scanner;

/**
 * 给定一个长度为 n 的数组 a1,a2,…,an 。
 * 
 * 现在，要将该数组从中间截断，得到三个非空子数组。
 * 
 * 要求，三个子数组内各元素之和都相等。
 * 
 * 请问，共有多少种不同的截断方法？
 * 
 * 输入格式 第一行包含整数 n 。
 * 
 * 第二行包含 n 个整数 a1,a2,…,an 。
 * 
 * 输出格式 输出一个整数，表示截断方法数量。
 * 
 * 数据范围 前六个测试点满足 1≤n≤10 。 所有测试点满足 1≤n≤105 ，−10000≤ai≤10000 。
 * 
 * 输入样例1： 4 1 2 3 3 输出样例1： 1
 * 
 * @author LykanHyper
 *
 */
public class Main_8 {
	static final int A = 100010;// 根据数据范围开辟数组长度
	static int sum[] = new int[A];
	static long result = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();// 数据个数
		for (int i = 1; i <= n; i++) {
			sum[i] = sum[i - 1] + scanner.nextInt();// 数组的前缀和
		}
		if (sum[n] % 3 != 0) {
			System.out.println(0);// 如果所有数的和不能整除3，则返回个数0
			return;
		}

		for (int i = 3,cnt = 0; i <= n; i++) {
			if(sum[i-2] == (sum[n]/3)) cnt++;
			if(sum[n]-sum[i-1]==(sum[n]/3)) result += cnt;
		} 
		System.out.println(result);
		scanner.close();
	}
}
