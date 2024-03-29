package lq_2022;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * [问题描述] 小蓝老师教的编程课有N名学生，编号依次是1...N。 第i号学生这学期 刷题的数量是Ai;。
 * 对于每一名学生，请你计算他至少还要再刷多少道题，才能使得全班刷题 比他多的学生数不超过刷题比他少的学生数。 [输入格式] 第一行包含一个正整数N。
 * 第二行包含N个整数: A1.A2.A3.... [输出格式] 输出N个整数，依次表示第1...N 号学生分别至少还要再刷多少道题。
 * 
 * @author LykanHyper
 *
 */
public class Main_4 {
	static int N;
	static int[] counts;
	static int mid;
	static int[] temp;

	public static void main(String[] args) throws InterruptedException {
		Scanner scanner = new Scanner(new BufferedInputStream(System.in));
		N = scanner.nextInt();
		counts = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			counts[i] = scanner.nextInt();
		}
		temp = Arrays.copyOf(counts, N+1);
		
		Arrays.sort(counts);

		if (counts.length % 2 == 0)
			mid = counts[counts.length/2];
		else
			mid = counts[(counts.length) / 2 + 1];
		System.out.println(mid);
		
		for(int i=1;i<=N;i++) {
			if(temp[i]>=mid) System.out.print(0+" ");
			else System.out.print(mid-temp[i]+1 + " ");
		}
	}
}
