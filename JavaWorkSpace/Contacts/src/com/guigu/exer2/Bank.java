package com.guigu.exer2;

public class Bank {
	private Customer[] customers;   		//存放多个客户的数组
	private int numberOfCustomer = 0;		//记录客户个数
	
	public Bank() {
		customers = new Customer[10];
	}
	//添加账户
	public void addCustomer(String f,String l) {
		Customer cus = new Customer(f,l);
		customers[numberOfCustomer++] = cus;
//		numberOfCustomer++;    //即为银行客户数量
			
	}
	//获取指定位置上的客户
	public Customer getCustomers(int index) {
//		return customers[index];    可能报异常
		if(index >= 0 && index < numberOfCustomer) {
			return customers[index];
			
		}else {
			return null;
		}
	}
	//获取用户个数
	public int getNumberOfCustomer() {
		return numberOfCustomer;
	}
	
}
