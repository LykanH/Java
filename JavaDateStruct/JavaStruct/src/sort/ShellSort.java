package sort;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 希尔排序的代码实现(通过交换式方法实现希尔排序<速度较慢>)
 * 交换式： 找到一个比当前数小的一个数就交换两者位置
 */
public class ShellSort {
	public static void main(String[] args) {
		// 产生i个随机数
		Scanner scanner = new Scanner(System.in);
		System.out.print("输入产生多少个随机数进行排序：");
		int all = scanner.nextInt();
		int[] ints = new int[all];
		for (int i = 0; i < all; i++) {
			ints[i] = (int) (Math.random() * 100);
		}

		System.out.println("排序前" + Arrays.toString(ints));

		long start = System.currentTimeMillis();
		
		ShellSort shellSort = new ShellSort();
		shellSort .shell(ints);
		
		long end = System.currentTimeMillis();
		System.out.println("排序后" + Arrays.toString(ints)); 

		System.out.println("总耗时为：" + (end - start));
		scanner.close();
	}

	public void shell(int[] ints) {
		for(int gap = ints.length / 2;gap > 0;gap = gap/2) {
			for(int i = gap;i < ints.length;i++) {
				for(int j = i - gap;j >= 0;j-=gap) {
					if (ints[j] > ints[j + gap]) {
						swap(ints, j, j+gap);
					}
				}
			}
		}
	}

	private void swap(int[] ints, int j, int k) {
		ints[j] = ints[j] ^ ints[k];
		ints[k] = ints[j] ^ ints[k];
		ints[j] = ints[j] ^ ints[k];
	}
}
