package com.guigu.exer1;

public class Account {
	
	//创建Account类的属性
	private int id;
	private double balance;
	private double annuallnterestRate;
	
	//创建构造器
	public Account(int id, double balance, double annuallnterestRate) {
		this.id = id;
		this.balance = balance;
		this.annuallnterestRate = annuallnterestRate;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnuallnterestRate() {
		return annuallnterestRate;
	}

	public void setAnnuallnterestRate(double annuallnterestRate) {
		this.annuallnterestRate = annuallnterestRate;
	}
	
	public void deposit(double amount) { //存钱
		if(amount > 0) {
			System.out.println("成功存入：" + amount + "元");
			this.balance += amount;
		}
	}
	
	public void withdraw(double amount) { //取钱
		
		if(this.balance >= amount) {
			this.balance -= amount;
			System.out.println("取款成功,余额为：" + this.balance);
			return;
		}else {
			System.out.println("余额不足，取款失败");
		}
	}
}
