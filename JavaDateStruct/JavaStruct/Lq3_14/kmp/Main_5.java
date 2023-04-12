package kmp;

import java.util.Scanner;

/**
 * 二分法的应用
 * 
 * @author LykanHyper
 *
 */
public class Main_5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("数组长度：");
		int n = scanner.nextInt();// 查询的数组中数据个数
		System.out.println(n);
		int q = scanner.nextInt();// q个查询
		System.out.println(q);

		int[] data = new int[n];
		for (int i = 0; i < n; i++) {
			data[i] = scanner.nextInt();
			System.out.println("***");
		}

		int[] nums = new int[q];
		for (int i = 0; i < q; i++) {
			nums[i] = scanner.nextInt();
			System.out.println("123");
		}

		for (int j = 0; j < q; j++) {
			// 调用二分法查询
			doubleSplit(nums[j], data);//寻找左右端点
		}
		scanner.close();
	}

	private static void doubleSplit(int target,int[] data) {
		int left = 0,right = data.length-1,mid;
		int start=0,end=0,i = 1;
		while(left <= right) {
			mid = (left+right)/2;
			if (data[mid] >= target) {
				right = mid;
			}else {
				left = mid+1;
			}
		}
	}

}
