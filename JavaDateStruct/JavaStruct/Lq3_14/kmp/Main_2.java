package kmp;

import java.util.Scanner;

/**
 * 斐波那契数列
 * 1,1,2,3,5,8,13,21...
 * @author LykanHyper
 *
 */
public class Main_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		System.out.println(new Main_2().backTracking(num));
	}
	public int backTracking(int num) {
		if (num==1||num==2) {
			return 1;
		}
		return backTracking(num-1)+backTracking(num-2);
	}
}
