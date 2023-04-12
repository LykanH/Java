package com.atguigu.exer;

public class RandomText {
	public static void main(String[] args) {
		int[] arr1 = new int[10];
		//给各个数组中的数赋值
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = (int)(Math.random()*90 + 10);	
		}
		//最大值
		int max = 0;
		int min = arr1[0];
		int sum = 0;
		for(int i = 0;i < arr1.length;i++) {
			max = max > arr1[i] ? max : arr1[i];
			min = min < arr1[i] ? min : arr1[i];
			sum += arr1[i];
		}
		double ave = (double)sum/arr1.length;
		System.out.print("各个随机数是：");
		for(int i = 0;i < arr1.length;i++) {
			System.out.print(arr1[i]+"\t");
			
		}
		System.out.println();
		System.out.println("最大值：" + max);
		System.out.println("最小值：" + min);
		System.out.println("和值：" + sum);
		System.out.println("平均值：" + ave);
	}
}
