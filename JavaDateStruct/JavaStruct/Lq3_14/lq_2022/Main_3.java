package lq_2022;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * [问题描述] 
 * 给定一个只包含大写字母的字符串S，请你输出其中出现次数最多的字母。 
 * 如果有多个字母均出现了最多次，按字母表顺序依次输出所有这些字母。
 * [输入格式] 
 * 一个只包含大写字母的字符串S. [输出格式] 若干个大写字母，代表答案。
 * 
 * @author LykanHyper
 *
 */
public class Main_3 {
	public static void main(String[] args) {
		int[] nums = new int[26];
		int max = 0;
		Scanner scanner = new Scanner(new BufferedInputStream(System.in));
		char[] chars = scanner.nextLine().toCharArray();
		for(int i=0;i<chars.length;i++) {
			int index = chars[i]-'A';
			nums[index]++;
			max = Math.max(max, nums[index]);
		}
		for(int i=0;i<nums.length;i++) {
			if(nums[i]==max) {
				System.out.print((char)(i+'A'));
			}
		}
	}
	
}