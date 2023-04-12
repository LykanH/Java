package com.atguigu.exer;

public class Text12_Girl {
	private String name;
	private int age;
	
	public Text12_Girl(){
		
	}
	public Text12_Girl(String name,int age) {
		this.name = name;
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getname() {
		return name;
	}
	public void setAge(int age) {
		this.age = age;
		
	}
	public int getAge() {
		return age;
	}
	public void marry(Text12_Boy boy) {
		System.out.println("名字是：" + boy.getName());
		boy.marry(this);
	}
	public int compare(Text12_Girl girl) {
		return this.getAge() - girl.getAge();
	}
	
	
}
