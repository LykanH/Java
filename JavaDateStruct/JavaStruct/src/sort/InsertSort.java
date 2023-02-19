package sort;

import java.util.Arrays;
import java.util.Scanner;

public class InsertSort {
	public static void main(String[] args) {
		//产生i个随机数
		Scanner scanner = new Scanner(System.in);
		System.out.print("输入产生多少个随机数进行排序：");
		int all = scanner.nextInt();
		int[] ints = new int[all];
		for(int i = 0;i < all;i++) {
			ints[i] = (int)(Math.random()*800000);
		}
		

//		System.out.println("排序前" + Arrays.toString(ints));
		
		long start = System.currentTimeMillis();
		//插入排序
		InsertSort insertSort = new InsertSort();
		insertSort.insert(ints);
		long end = System.currentTimeMillis();
//		System.out.println("排序后" + Arrays.toString(ints));
		
		System.out.println("总耗时为：" + (end-start));
		scanner.close();
	}
	
	public void insert(int[] ints) {
		for(int i = 1;i < ints.length;i++) {
			for(int j = i;j > 0;j--) {
				if (ints[j] < ints[j - 1]) {
					swap(ints, j, j-1);
				}else {
					break;
				}
			}
		}
	}

	private void swap(int[] ints, int j, int k) {
		ints[j] = ints[j]^ints[k];
		ints[k] = ints[j]^ints[k];
		ints[j] = ints[j]^ints[k];
	}
}
