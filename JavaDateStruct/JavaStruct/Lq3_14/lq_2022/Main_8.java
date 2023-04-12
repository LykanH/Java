package lq_2022;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * 给定一个长度为 n 的整数序列，请找出最长的不包含重复的数的连续区间，输出它的长度。
 * 
 * 输入格式 第一行包含整数 n 。
 * 
 * 第二行包含 n 个整数（均在 0∼10^5 范围内），表示整数序列。
 * 
 * 输出格式 共一行，包含一个整数，表示最长的不包含重复的数的连续区间的长度。
 * 
 * 数据范围 1≤n≤10^5 输入样例： 5
 * 
 * 1 2 2 3 5 输出样例： 3
 * 
 * @author LykanHyper
 *
 */
public class Main_8 {
	static int[] nums = new int[100010];
	static int n;
	static int res=0;
	static int[] temp = new int[100010];
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedInputStream(System.in));
		n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			nums[i] = scanner.nextInt();
		}
		for(int i=0,j=0;i<n;i++) {
			temp[nums[i]]++;
			
			while(j<=i&&temp[nums[i]]>1) {
				temp[nums[j]]--;
				j++;
			}
			res=Math.max(res, i-j+1);
		}
		System.out.println(res);
	}
}
