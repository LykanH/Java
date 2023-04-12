package AbstractTest;
/*
 * 编写Employee类，声明为抽象类
 * 包含三个属性：name、id、salary
 * 提供必要的构造器和抽象方法：work();
 * 对于Manager类来说，他既是员工，还具有奖金（bonus）的属性
 * 请使用继承的思想，设计CommonEmployee类和Manager类，要求类中提供必要的方法
 * 进行属性访问
 */

public abstract class Employee {
	private String name;
	private int age;
	private int salary;
	
	public Employee() {
		
	}
	public Employee(String name,int age,int salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	
	public abstract void work();
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}


