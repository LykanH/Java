package com.atguigu.exer;

public class YangHuiText {
	public static void main(String[] args) {
		int[][] arr1 = new int[10][];
//		arr1[1] = new int[1];
		// 给每一行初始化
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = new int[i + 1];
			// 给每一行的第一个值和最后一个值赋值为1;
			arr1[i][0] = 1;
			arr1[i][i] = 1;
			if (i >= 2) {
				for(int j = 1;j < arr1[i].length - 1;j++) {
					arr1[i][j] = arr1[i - 1][j - 1]+arr1[i - 1][j];
				}
			}
		}
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[i].length; j++) {
				System.out.print(arr1[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
