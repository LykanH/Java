package com.guigu.obj;
//对象的创建和使用
public class Text1 {
	public static void main(String[] args) {
		Student stu1 = new Student();
		stu1.name = "xiaoming";
		stu1.age = 20;
		stu1.major = "Math";
		stu1.interesting = "basketball";
		System.out.println(stu1.name);
		System.out.println(stu1.say());
	}
}

class Student{
	String name;
	int age;
	String major;
	String interesting;
	public String say() {
		String inf;
		inf = "姓名：" + name + "\n" + "年龄：" +age + "\n" + "学科：" + major;
		return inf;
	}
}