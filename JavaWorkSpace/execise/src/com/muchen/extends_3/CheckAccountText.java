package com.muchen.extends_3;

public class CheckAccountText {
	public static void main(String[] args) {
		CheckAccount acc2 = new CheckAccount(1122, 20000, 0.045, 5000);
		acc2.withdraw(5000);
		System.out.println("账户余额：" + acc2.getBalance());
		System.out.println("可透支额：" + acc2.getOverdraft());
		
		System.out.println("*********************************************");
		
		acc2.withdraw(18000);
		System.out.println("账户余额：" + acc2.getBalance());
		System.out.println("可透支额：" + acc2.getOverdraft());
		
		System.out.println("*********************************************");
		
		acc2.withdraw(3000);
		System.out.println("账户余额：" + acc2.getBalance());
		System.out.println("可透支额：" + acc2.getOverdraft());
	}
}
