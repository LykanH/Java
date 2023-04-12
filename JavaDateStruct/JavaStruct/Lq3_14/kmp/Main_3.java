package kmp;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 100 可以表示为带分数的形式：100=3+69258/714 还可以表示为：100=82+3546/197 注意特征：带分数中，数字 1∼9
 * 分别出现且只出现一次（不包含 0 ）。
 * 
 * 类似这样的带分数，100 有 11 种表示法。
 * 
 * 输入格式 一个正整数。
 * 
 * @author LykanHyper
 *
 */
public class Main_3 {
	// 思路：先将1到9的全排列给列出来
	static int[] temp = new int[9];// 存放排列后的数据
	boolean[] bools = new boolean[9];// 用于全排列判断数字是否使用过
	int result = 0;

	public static void main(String[] args) {
		new Main_3().backTracking(0,100);
		System.out.println(new Main_3().result);
		System.out.println(123);
	}

	public void backTracking(int num,int n) {
		if (num == 9) {
			int a=0,b=0,c=0;
			for(int i=0;i<7;i++) {
				a=cal(0, i);
				if (a > n||a==0) {
					break;
				}
				for(int j = i;j < 8;j++) {
					if (8-j-1>j-i-1) {
						break;//分子大于分母
					}
					b=cal(i,j);
					c=cal(j, 8);
					if (b==n*c-c*a) {
						result++;
					}
				}
			}
			return;
		}
		for (int i = 1; i <= 9; i++) {
			if (!bools[i-1]) {
				temp[num] = i;
				bools[i-1] = true;
				backTracking(num + 1,n);
				bools[i-1] = false;
			}
		}

	}
	public int cal(int start,int end) {
		int res = 0;
		for(int i=start;i<end;i++) {
			res = res*10+temp[i];
		}
		return res;
	}
}
