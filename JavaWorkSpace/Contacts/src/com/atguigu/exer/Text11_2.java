package com.atguigu.exer;

public class Text11_2 {
	public static void main(String[] args) {
		Text11 stu1 = new Text11("zhangsan", 18);
		Text11 stu2 = new Text11("lisi", 20, "大学");
		Text11 stu3 = new Text11("wnagwu", 22, "博士", "软工");
		System.out.println(stu1.name + "\t" + stu1.age);
		System.out.println(stu2.name + "\t" + stu2.age + "\t" + stu2.school);
		System.out.println(stu3.name + "\t" + stu3.age + "\t" + stu3.school
				+ "\t" + stu3.major);
	}
}