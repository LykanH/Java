package com.muchen.extends_4;
/*
 * (4）参照SalariedEmployee类定义HourlyEmployee类，
 * 		实现按小时计算工资的员工处理。该类包括:
 * 		private成员变量wage和hour;
 * 		实现父类的抽象方法earnings，该方法返回wage*hour值
 * 		toString方法输出员工类型信息及员工的name，number，birthday
 */
public class HourlyEmployee extends SalariedEmployee{

	private double wage;
	private int hour;
	
	public HourlyEmployee(double wage,int hour,double monthSalary, String name, int number, MyDate birthday) {
		super(monthSalary, name, number, birthday);
		// TODO Auto-generated constructor stub
		this.wage = wage;
		this.hour = hour;
	}
	
	public double earnings() {
		return (wage * hour);
	}

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}
	
//	public String toString() {
//		return ;
//	}
}
