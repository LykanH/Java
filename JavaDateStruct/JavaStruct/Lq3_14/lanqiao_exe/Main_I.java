package lanqiao_exe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

//素数
public class Main_I {
//	static ArrayList<Integer> tempArrayList = new ArrayList<Integer>();
	static int[] ints = new int[100];
	public static void main(String[] args) {
		int i,k=0;
		for(i=1;i <= 100;i++) {			
			boolean flag = true;
			if(i<2) flag = true;
			for(int j=2;j<=i/j;j++) {
				if (i%j==0) {
					flag = false;
				}
			}
			if(flag) ints[k++]=i;
		}
		System.out.println(Arrays.toString(ints));
	}
}
