package com.atguigu.exer;

import javax.management.RuntimeErrorException;

/**
 * 
 * @Description 构造器的使用
 * @author muchen
 * @version
 * @date 2022年5月7日下午2:25:52
 *
 */
/*
 * 3.编写两个类，TriAngle和TriAngleTest，其中TriAngle类中声明私有
 * 的底边长base和高height，同时声明公共方法访问私有变量。 
 * 此外，提供类必要的构造器。另一个类中使用这些公共方法，计算三角形的面积。
 */
public class Text10 {
	public static void main(String[] args) {
		AriAngle a1 = new AriAngle();
		a1.setBase(10);
		a1.setHeight(50);
		System.out.println("三角形的底：" + a1.getBase());
		System.out.println("三角形的高：" + a1.getHeight());
		System.out.println("三角形的面积：" + a1.calculate());
	}
}

class AriAngle {
	private double base;
	private double height;

	public AriAngle() {
		System.out.println("实例化对象成功！");
	}

	public void setBase(double a) {
		if (a > 0) {
			base = a;
		}else {
			throw new RuntimeException("输入的底值不对，请重新输入！");
		}
	}
	
	public double getBase() {
		return base;
	}
	public void setHeight(double b) {
		height = b;
	}
	public double getHeight() {
		return height;
	}
	public double calculate() {
		return base * height * 1 / 2;
	}
}