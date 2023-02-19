package kmp;

import java.util.Arrays;
import java.util.Iterator;

/*
 * 使用KMP算法实现判断一个字符串是否为长字符串的子字符串。
 * 如果是返回下标(假设只出现一次)
 * 如果不是返回 -1
 */

public class KMPAlgorithm {
	public static void main(String[] args) {
		String str1 = "BBC ABCDAB ABCDABCDABDE";
		String str2 = "ABCDABD";
		KMPAlgorithm kmpAlgorithm = new KMPAlgorithm();
//		System.out.println(Arrays.toString(kmpAlgorithm.getNext(str2)));
		int[] next = kmpAlgorithm.getNext(str2);
		System.out.println(kmpAlgorithm.kmpSearch(str1, str2, next));
	}
	
	//实现KMP算法	需传入父串、子串、
	public int kmpSearch(String str1,String str2,int[] next) {
		for(int i = 0,j = 0;i < str1.length();i++) {
			if (j > 0 && str1.charAt(i) != str2.charAt(j)) {
				j = next[j-1];
			}
			if (str1.charAt(i) == str2.charAt(j)) {
				j++;
			}
			if (j == str2.length()) {
				return i-j+1;
			}
		}
		return -1;
	}
	
	//获得子串的对应的next数组
	//即原模式串子串对应的各个前缀后缀的公共元素的最大长度表 简称《最大长度表》
	public int[] getNext(String string) {
		char[] array = string.toCharArray();
		int[] next = new int[array.length];
		next[0] = 0;
		for(int j = 0,i = 1;i < next.length;i++) {
			//KMP算法核心：
			//当子串中元素不相等时
			if (j > 0 && array[i]!=array[j]) {
				j = next[j-1];
			}
			
			//当子串中两个元素相等时
			if(array[i] == array[j]) {
				j++;
			}
			next[i] = j;
		}
		
		return next;
	}
}
