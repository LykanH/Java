package kmp;

import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

/**
 * 小明正在玩一个“翻硬币”的游戏。
 * 
 * 桌上放着排成一排的若干硬币。我们用 * 表示正面，用 o 表示反面（是小写字母，不是零）。
 * 
 * 比如，可能情形是：**oo***oooo
 * 
 * 如果同时翻转左边的两个硬币，则变为：oooo***oooo
 * 
 * 现在小明的问题是：如果已知了初始状态和要达到的目标状态，每次只能同时翻转相邻的两个硬币,那么对特定的局面，最少要翻动多少次呢？
 * 
 * 我们约定：把翻动相邻的两个硬币叫做一步操作。
 * 
 * 输入格式 两行等长的字符串，分别表示初始状态和要达到的目标状态。
 * 示例1： *o**o***o***
 		*o***o**o***  		
 	输出： 1
 	
 	示例2：**********
		 o****o****
	输出：5
 * @author LykanHyper
 *
 */
public class Main_4 {
	static char[] start_chars;
	static char[] end_chars;
	static int result = 0;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		String start = scanner.nextLine();//起初给定的硬币顺序
////		scanner.nextLine();
//		String aim = scanner.nextLine();//最终需要达到的硬币顺序
//		start_chars = start.toCharArray();
//		end_chars = aim.toCharArray();
		start_chars = scanner.nextLine().toCharArray();
		end_chars = scanner.nextLine().toCharArray();
		for(int i=0;i<start_chars.length-1;i++) {
			if (start_chars[i]!=end_chars[i]) {
				exchange(i);
				result++;
			}
		}
		System.out.println(result);
	}
	
	public static void exchange(int i) {
		if (start_chars[i]=='*') {
			start_chars[i]='o';
		}else {
			start_chars[i]='*';
		}
		if (start_chars[i+1]=='*') {
			start_chars[i+1]='o';
		}else {
			start_chars[i+1]='*';
		}
	}
}
