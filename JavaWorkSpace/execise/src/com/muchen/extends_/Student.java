package com.muchen.extends_;

public class Student extends Person{
	private long number;
	private int math;
	private int english;
	private int computer;
	
	public Student() {
		
	}
	public Student(String name,char sex,int age,long number,int math,int english,int computer) {
		this.name =name;
		this.sex = sex;
		this.age = age;
		this.number = number;
		this.math = math;
		this.english = english;
		this.computer = computer;
	}
	public double ave() {
		return (math + english + computer)/3;
	}
	public int max() {
		int max;
		max = math > (english > computer ? english : computer) ? math : (english > computer ? english : computer);
		return max;
	}
	public int min() {
		int min;
		min = math < (english < computer ? english : computer) ? math : (english < computer ? english : computer);
		return min;
	}
}
