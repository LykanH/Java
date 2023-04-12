package kmp;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 实现KMP算法
 * @author LykanHyper
 *
 */
public class KMP_Alogorithm {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "aabaabaafa";
		String s2 = "aabaaf";
//		char[] c1 = s1.toCharArray();
//		char[] c2 = s2.toCharArray();
		int nextCreat = new KMP_Alogorithm().nextCreat(s1, s2);
		System.out.println(nextCreat);
		
		
	}
	public int nextCreat(String s1,String s2) {
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		int[] next = new int[s2.length()];
		//j为前缀末尾位置，i为后缀末尾位置
		int j = 0;
		next[0] = 0;
		for(int i = 1;i < next.length;i++) {
			while(j > 0 && c2[i] != c2[j]) {
				j = next[j-1];
			}
			if (c2[i] == c2[j]) {
				j++;
				next[i] = j;
			}
		}
		System.out.println(Arrays.toString(next));
		j = 0;
		for(int i = 0; i < c1.length;i++ ) {
			while (j > 0 && c1[i] != c2[j]) {
				j = next[j-1];
			}
			if (c1[i] == c2[j]) {
				j++;
			}
			if (j == c2.length) {
				return (i-c2.length + 1);
			}
		}
		return -1;
	}
}
