package com.guigu.exer2;

public class Customer {
	private String firstName;
	private String lastName;
	private Account account;
	
	//构造方法
	public Customer(String f,String l) {
		this.firstName = f;
		this.lastName = l;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account acct) {
		this.account = acct;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	
}
