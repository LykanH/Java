package com.muchen.extends_3;

public class Account {
	private int id;
	private double balance;
	private double annuallnterestRate;
	
	public Account(int id, double balance, double annuallnterestRate) {
		super();
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
	
	public void withdraw(double amounr) {
		if(balance >= amounr) {
			balance -= amounr;
		}else {
			System.out.println("余额不足，取钱失败！");
			System.out.println("账户里还有"+ balance +"元");
		}
	}
	
	public void deposit(double amount) {
		balance += amount;
		System.out.println("存钱成功！");
	}
	
	public double getMonthlyInterest() {
		return annuallnterestRate / 12;
	}
	
}
