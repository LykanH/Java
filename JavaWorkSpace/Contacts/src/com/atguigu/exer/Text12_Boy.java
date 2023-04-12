package com.atguigu.exer;

public class Text12_Boy {
	private String name;
	private int age;
	
	//构造器
	public Text12_Boy(){
		
	}
	public Text12_Boy(String name,int age) {
		this.name = name;
		this.age = age;
	}
	public Text12_Boy(String name) {
		this.name = name;
	}
	
	public void marry(Text12_Girl girl) {
		System.out.println("名字为：" + girl.getname());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	public void shout() {
		if(age >= 22) {
			System.out.println("年龄已够！");
		}else {
			System.out.println("年龄还不够！");
		}
	}
}
