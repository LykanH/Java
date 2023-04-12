package com.muchen.extends_4;
/*
  	(1）定义一个Employee类，该类包含:
		private成员变量name,number,birthday，其中birthday为MyDate类的
		对象;abstract方法earnings():
		toString()方法输出对象的name,number和birthday。
 */
public abstract class Employee {
	private String name;
	private int number;
	private MyDate birthday;
	
	
	public Employee(String name, int number, MyDate birthday) {
		super();
		this.name = name;
		this.number = number;
		this.birthday = birthday;
	}

	public abstract double earnings() ;
	
	public String toString() {
		return "名字：" + name +"工号：" + number + "生日" + birthday.toDateString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public MyDate getBirthday() {
		return birthday;
	}

	public void setBirthday(MyDate birthday) {
		this.birthday = birthday;
	}
	
}
