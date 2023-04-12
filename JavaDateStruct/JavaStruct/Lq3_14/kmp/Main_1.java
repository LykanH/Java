package kmp;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 输入格式 输入一个整数 n 。
 * 
 * 输出格式 每行输出一种方案。
 * 
 * 同一行内的数必须升序排列，相邻两个数用恰好 1 个空格隔开。
 * 
 * 对于没有选任何数的方案，输出空行。
 * 
 * 本题有自定义校验器（SPJ），各行（不同方案）之间的顺序任意。
 * 
 * 输入样例： 3 
 * 
 * 输出样例：
 * 
 * 3
 * 2
 * 2 3 
 * 1 
 * 1 3 
 * 1 2 
 * 1 2 3
 * 
 * @author LykanHyper
 *
 */
public class Main_1 {
	LinkedList<Integer> temp = new LinkedList<Integer>();
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//输入
		int num = scanner.nextInt();
		new Main_1().backTracking(1, num);
		for(int i = 1; i<=num;i++) {
			System.out.print(i+" ");
		}
	}
	public void backTracking(int startIndex, int num) {
		if(temp.size()==num) {
			return;
		}
		for(int i:temp) {
			System.out.print(i+" ");
		}
		System.out.println();
		for(int i = startIndex;i <=num;i++) {
			temp.add(i);
			backTracking(i+1, num);
			temp.removeLast();
		}
		
	}
}
