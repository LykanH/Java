package com.guigu.exer2;

import com.guigu.exer1.AccountText;

public class BankText {
	public static void main(String[] args) {
		Bank bank = new Bank();
		bank.addCustomer("杨", "万里");
		bank.addCustomer("niu", "niu");
		
	
		
		bank.getCustomers(0).setAccount(new Account(2000));
		
		int a = bank.getNumberOfCustomer();
		System.out.println(a);
		bank.getCustomers(0).getAccount().deposit(748);
		bank.getCustomers(0).getAccount().withdraw(435);
		System.out.println(bank.getCustomers(0).getFirstName()+
				bank.getCustomers(0).getLastName()+"的账户余额为："+
				bank.getCustomers(0).getAccount().getBalance()); 
		
	}
}
