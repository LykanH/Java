package com.guigu.exer2;

public class Account {
	private double balance;
	
	//构造器
	public Account(double init_balance) {
		this.balance = init_balance;
	}
	public double getBalance() {
		return balance;
	}
	public void deposit(double amt) {
		if(amt > 0) {
			this.balance += amt;
			System.out.println("存款成功，存入" + amt + "元");
		}
	}
	public void withdraw(double amt) {
		if(this.balance > amt) {
			this.balance -= amt;
			System.out.println("取款成功！");
		}else {
			System.out.println("余额不足！");
		}
	}
}
