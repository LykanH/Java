package sort;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 冒泡排序代码实现
 */
public class BubbleSort {
//	final int i = 15;
	public static void main(String[] args) {
		//产生i个随机数
		Scanner scanner = new Scanner(System.in);
		System.out.print("输入产生多少个随机数进行排序：");
		int all = scanner.nextInt();
		int[] ints = new int[all];
		for(int i = 0;i < all;i++) {
			ints[i] = (int)(Math.random()*101);
		}
		
		long start = System.currentTimeMillis();
		
		System.out.println("排序前" + Arrays.toString(ints));
		
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.bubble(ints);

		System.out.println("排序后" + Arrays.toString(ints));
		
		long end = System.currentTimeMillis();
		System.out.println("总耗时为：" + (end-start));
		
		scanner.close();
	}
	//冒泡排序
	public void bubble(int[] ints) {
		for(int i = 0;i < ints.length - 1;i++) {
			for(int j = 0;j < ints.length -1- i;j++) {
				if(ints[j] > ints[j+1]) swap(ints,j,j+1);
			}
		}
	}

	private void swap(int[] ints, int j, int k) {
		ints[j] = ints[j]^ints[k];
		ints[k] = ints[j]^ints[k];
		ints[j] = ints[j]^ints[k];
	}
}







