package lq_2022;


/**
 * [问题描述] 这天小明正在学数数。 他突然发现有些正整数的形状像一-座“山”，比如123565321、145541， 它
 * 们左右对称(回文)且数位上的数字先单调不减，后单调不增。 
 * 小明数了很久也没有数完，他想让你告诉他在区间[2022,2022222022]中有
 * 多少个数的形状像一座“山 [答案提交]
 * 
 * @author LykanHyper
 *
 */

public class Main_2 {
	public static void main(String[] args) {
		String s1 = null;
		long ans = 0;
		for(int i=2022;i<=2022222022;i++) {
			s1 = i+"";
			if (check(s1)) {
				ans++;
			}
		}
		System.out.println(ans);
	}

	private static boolean check(String string) {
		char[] array = string.toCharArray();
		for(int i=0,j=array.length-1;i<=j;i++,j--) {
			if(i>0&&array[i]<array[i-1]) {
				return false;
			}
			if(array[i]!=array[j]) {
				return false;
			}
		}
		return true;
	}
	
}