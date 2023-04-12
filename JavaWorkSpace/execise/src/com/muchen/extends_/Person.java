package com.muchen.extends_;
/**
 * 
 * @Description 继承性的练习
 * @author muchen
 * @version
 * @date 2022年5月13日下午3:51:49
 *
 */
public class Person {
	public String name;
	public char sex;
	public int age;
	
	public Person() {
		
	}
	public Person(String name,char sex,int age) {
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
	
	public String toString() {
//		System.out.println(name + "同学"+ age + "岁了");
		String stu =  name + "同学"+ age + "岁了";
		return stu;
	}
	
}
