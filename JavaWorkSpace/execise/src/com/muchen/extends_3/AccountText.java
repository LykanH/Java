package com.muchen.extends_3;

public class AccountText {
	public static void main(String[] args) {
		Account acc1 = new Account(1122, 20000, 0.045);
		
		acc1.withdraw(30000);
		System.out.println("余额为：" + acc1.getBalance());
		acc1.withdraw(2500);
		acc1.deposit(3000);
		System.out.println("余额为：" + acc1.getBalance());
		System.out.println("月利率为：" + acc1.getMonthlyInterest());
	}
}
