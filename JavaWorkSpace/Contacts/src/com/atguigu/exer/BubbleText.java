package com.atguigu.exer;

public class BubbleText {
	public static void main(String[] args)
	{
		//创建一个整形数组
		int[] arr = new int[] {34,56,-23,-76,-1,4,6,2,7,34,24};
		//冒泡排序
		for(int i = 0;i < arr.length - 1;i++) {
			for(int j = 0;j  < arr.length - 1 -i;j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for(int i = 0;i < arr.length;i++) {
			System.out.print(arr[i]+"\t");
		}
	}
}
