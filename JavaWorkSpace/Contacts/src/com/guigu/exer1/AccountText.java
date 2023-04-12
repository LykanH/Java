package com.guigu.exer1;

public class AccountText {
	public static void main(String[] args) {
		Customer cus = new Customer("Jane", "Smith");
		
		Account acc = new Account(1000, 2000, 0.0123);
		
		cus.setAccount(acc);
		
		cus.getAccount().deposit(100);
		cus.getAccount().withdraw(960);
		cus.getAccount().withdraw(2000);
	}	
}
