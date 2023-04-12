package com.muchen.extends_4;
/*
 * (3）定义SalariedEmployee类继承Employee类，实现按月计算工资
 * 		的员工处理。该类包括: private成员变量monthlySalary;
		实现父类的抽象方法earnings(),该方法返回monthlySalary值:
		 toString()方法输出员工类型信息及员工的name，number,birthday。

 */
public class SalariedEmployee extends Employee{
	

	private double monthSalary;  //月工资
	
	public SalariedEmployee(String name, int number, MyDate birthday) {
		super(name, number, birthday);
		// TODO Auto-generated constructor stub
	}
	
	public SalariedEmployee(double monthSalary,String name, int number, MyDate birthday) {
		super(name, number, birthday);
		// TODO Auto-generated constructor stub
		this.monthSalary = monthSalary;
	}
	
	
	
	public double getMonthSalary() {
		return monthSalary;
	}

	public void setMonthSalary(double monthSalary) {
		this.monthSalary = monthSalary;
	}

	public double earnings() {
		return monthSalary;
	}
	
	public String toString() {
		return "[" + super.toString() +"]";
	}
}
