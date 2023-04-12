package com.atguigu.exer;

import java.util.Scanner;

public class ArrayText {
	public static void main(String[] args) {
		// 创建学生人数：
		int max;
		System.out.println("请输入学生个数：");
		Scanner scan = new Scanner(System.in);
		int studentNum = scan.nextInt();

		// 创建数组
		int[] grade = new int[studentNum];
		System.out.println("请输入" + studentNum + "个成绩：");
		for (int i = 0; i < studentNum; i++) {
			grade[i] = scan.nextInt();
		}
		max = grade[0];
		for(int i = 0;i < studentNum - 1;i++)
		{
			max = max > grade[i+1] ? max : grade[i+1];
		}
		System.out.println("最高分为：" + max);
		for(int i = 0;i < studentNum;i++)
		{
			if(max - grade[i] <= 10)
			{
				System.out.println((i+1) + "号学生成绩的等级为A");
			}
			else if(max - grade[i] <= 20)
			{
				System.out.println((i+1) + "号学生成绩的等级为B");
			}
			else if(max - grade[i] <= 30)
			{
				System.out.println((i+1) + "号学生成绩的等级为C");
			}
			else
			{
				System.out.println((i+1) + "号学生成绩的等级为D");
			}
		}

	}
}
