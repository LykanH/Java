package kmp;
/*
 * 暴力算法实现字符串匹配，如果匹配到返回下标，未匹配到返回-1
 */
public class VoilenceMatch {
	public static void main(String[] args) {
		String s1 = "basadbace";
		String s2 = "bac";
		System.out.println( new VoilenceMatch().voilenceMatch(s1, s2));
	}
	
	
	public int voilenceMatch(String s1,String s2) {
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		
		int i = 0;
		int j = 0;
		while(i < c1.length && j < c2.length) {
			if (c1[i] == c2[j]) {
				i++;
				j++;
			}else {
				i = i - (j - 1);
				j = 0;
			}
		}
		if(j == c2.length) {
			return i - j;
		}else {
			return -1;
		}
		
	}
}
