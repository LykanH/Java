package sort;


/*
 * 选择排序的实现
 */

import java.util.Arrays;
import java.util.Scanner;

public class SelectSort {
	public static void main(String[] args) {
		//产生i个随机数
		Scanner scanner = new Scanner(System.in);
		System.out.print("输入产生多少个随机数进行排序：");
		int all = scanner.nextInt();
		int[] ints = new int[all];
		for(int i = 0;i < all;i++) {
			ints[i] = (int)(Math.random()*101);
		}

		System.out.println("排序前" + Arrays.toString(ints));
		long start = System.currentTimeMillis();
		
		//选择排序后
		SelectSort selectSort = new SelectSort();
		selectSort.select(ints);
		System.out.println("排序后" + Arrays.toString(ints));
		
		long end = System.currentTimeMillis();
		System.out.println("总耗时为：" + (end-start));
		
		scanner.close();
		
	}
	
	//选择排序
	public void select(int[] ints) {
		for(int i = 0;i < ints.length - 1;i++) {
			int minNum = i;
			int min = ints[i];
			for(int j = i + 1;j < ints.length;j++) {
				if(min > ints[j]) {
//					min = ints[i];
					min = ints[j];
					minNum = j;
				}
//				minNum = ints[minNum] > ints[j] ? j : minNum;
			}
			swap(ints, minNum, i);
		}
	}

	private void swap(int[] ints, int j, int k) {
		ints[j] = ints[j]^ints[k];
		ints[k] = ints[j]^ints[k];
		ints[j] = ints[j]^ints[k];
	}
}
