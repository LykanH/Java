package com.atguigu.exer;

public class Text {
	public static void main(String[] args) {
		int a = 10;
		int b = 10;
		method(a,b);	//需要method方法被调用之后，进打印出a = 100 b = 200
						//写出method方法的代码
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		
	}
	public static void method(int a,int b) {
		a *= 10;
		b *= 20;
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.exit(0);                  //从这里直接结束整个程序！
	}
}
