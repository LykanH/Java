package com.atguigu.exer;

public class PassObject {
	public static void main(String[] args) {
		Circle squ = new Circle();
		
		PassObject obj = new PassObject();
		for(int i = 1;i <= 5;i++) {
			squ.radius = i;
			obj.printAreas(squ,(int)squ.radius);
		}
		
		
		
	}
	
	public void printAreas(Circle c,int time) {
		System.out.println("Radius \t\t\t Area");
		
		System.out.print((double)time + "\t\t\t" + c.findArea());
		
	}
}
