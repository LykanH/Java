package com.muchen.extends_;

public class StudentText {
	public static void main(String[] args) {
		Student stu1 = new Student("王明", '男', 20, 2020020659, 93, 78, 95);
		
		
		System.out.println(stu1.toString()); 
		System.out.println("姓名：" + stu1.name);
		System.out.println("性别：" + stu1.sex);
		System.out.println("年龄：" + stu1.age);
		System.out.println("平均值为：" + stu1.ave());
		System.out.println("最大值为：" + stu1.max());
		System.out.println("最小值为：" + stu1.min());
	}
}
