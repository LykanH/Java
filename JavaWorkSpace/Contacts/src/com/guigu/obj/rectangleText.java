package com.guigu.obj;

import java.util.Scanner;

public class rectangleText {
	public static void main(String[] args) {
		rectangle rect1 = new rectangle();
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入长方体的长");
		int width = scan.nextInt();
		System.out.println("请输入长方体的宽：");
		int height = scan.nextInt();
		rect1.rectWidth = width;
		rect1.rectHeight = height;
		rect1.len1();
		int area = rect1.area();
		System.out.println(area);
	}
}

class rectangle {
	int rectWidth;
	int rectHeight;

	public void len1() {
		for (int i = 0; i < rectHeight; i++) {
			for (int j = 0; j < rectWidth; j++) {
				System.out.print("*");

			}
			System.out.println();
		}
	}

	public int area() {
		System.out.println();
		System.out.println();
		System.out.print("该长方体的面积是：");
		return (rectHeight * rectWidth);
	}
}