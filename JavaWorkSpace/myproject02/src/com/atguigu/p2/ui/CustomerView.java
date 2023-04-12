package com.atguigu.p2.ui;

import com.atguigu.p2.bean.Customer;
import com.atguigu.p2.service.CustomerList;

/**
 * 
 * @Description:主模块，负责菜单的显示和处理用户操作
 * @author muchen
 * @version
 * @date 2022年5月12日下午5:32:01
 *
 */

import com.atguigu.p2.util.CMUtility;

public class CustomerView {
	CustomerList customerList = new CustomerList(10);

	public CustomerView() {
		Customer customer = new Customer("jhon", '男', 23, "21321312", "1231312@qq.com");
		customerList.addCustomer(customer);
	}

	// method
	// 显示《客户信息管理软件》界面的方法
	public void enterMainMenu() {
		boolean flag = true;
		while (flag) {
			System.out.println("--------------客户信息管理软件----------------");
			System.out.println("              1 添加客户");
			System.out.println("              2 修改客户");
			System.out.println("              3 删除客户");
			System.out.println("              4 客户列表");
			System.out.println("              5 退	出");
			System.out.print("                请选择(1—5)： ");
			int m = CMUtility.readMenuSelection();
			switch (m) {
			case 1: {
				addNewCustomer();
				break;
			}
			case 2: {
				modifyCustomer();
				break;
			}
			case 3: {
				deleteCustomer();
				break;
			}
			case 4: {
				listAllCustomers();
				break;
			}
			case 5: {
//					System.out.println("退出");
				System.out.println("确定退出吗？(Y/N):");
				char confirm = CMUtility.readChar();
				if (confirm == 'Y' || confirm == 'y') {
					flag = false;
					System.out.println("程序已退出！");
				}
				break;
			}
			}
//			flag = false;
		}

	}

	// 添加客户的操作
	private void addNewCustomer() {
//		System.out.println("添加客户");
		System.out.println("---------------------------添加客户-------------------------");
		System.out.print("姓名：");
		Customer cus2 = new Customer();
		cus2.setName(CMUtility.readString(10));
		System.out.print("性别：");
		cus2.setGender(CMUtility.readChar());
		System.out.print("年龄：");
		cus2.setAge(CMUtility.readInt());
		System.out.print("电话：");
		cus2.setPhone(CMUtility.readString(11));
		System.out.print("邮箱：");
		cus2.setEmail(CMUtility.readString(11));

//		customerList.addCustomer(cus2);		//添加上边输入的客户

		boolean isSuccess = customerList.addCustomer(cus2); // 添加用户并返回返回值
		if (isSuccess) {
			System.out.println("---------------------------添加完成-------------------------");
		} else {
			System.out.println("---------------------------添加失败-------------------------");
		}

	}

	// 修改客户的操作
	private void modifyCustomer() {
//		System.out.println("修改客户");

		for (;;) {
			System.out.print("输入您要修改客户的编号(-1退出)：");
			int num = CMUtility.readInt();
			if (num == -1) {
				return;
			} else if (num > 0 && num <= customerList.getTotal()) {
				Customer[] cus = customerList.getAllCustomers();

				System.out.print("姓名(" + cus[num - 1].getName() + ")：");
				cus[num - 1].setName(CMUtility.readString(10));
				System.out.print("性别(" + cus[num - 1].getGender() + ")：");
				cus[num - 1].setGender(CMUtility.readChar());
				System.out.print("年龄(" + cus[num - 1].getAge() + ")：");
				cus[num - 1].setAge(CMUtility.readInt());
				System.out.print("电话(" + cus[num - 1].getPhone() + ")：");
				cus[num - 1].setPhone(CMUtility.readString(11));
				System.out.print("邮箱(" + cus[num - 1].getEmail() + ")：");
				cus[num - 1].setEmail(CMUtility.readString(11));
				return;
			} else {
				System.out.println("你输入的用户不存在，请重新输入！");
			}
		}
	}

	// 删除客户的操作
	private void deleteCustomer() {
//		System.out.println("删除客户");
		for (;;) {
			System.out.print("请输入你要删除用户的编号(-1退出)：");
			int num = CMUtility.readInt();
			if (num == -1) {
				return;
			}

//			if(isSure == 'Y' || isSure == 'y') {
			boolean isSuccess = customerList.deleteCustomer(num - 1);
			if (isSuccess) {
				System.out.println("确定要删除该用户吗？(Y/N)");
				char isSure = CMUtility.readChar();
				if (isSure == 'Y' || isSure == 'y') {
					System.out.println("---------------------------删除成功-------------------------");
					return;
				}
			} else {
				System.out.println("---------------------------删除失败-------------------------");
			}
		}

	}

	// 显示客户列表的操作
	private void listAllCustomers() {
//		System.out.println("显示客户列表");
		System.out.println("---------------------------客户列表-------------------------");
		if (customerList.getTotal() <= 0) {
			System.out.println("没有客户记录！");
		} else {
			System.out.println("编号 \t姓名 \t 性别 \t 年龄 \t 电话 \t\t 邮箱");
			Customer[] cus = new Customer[customerList.getTotal()];
			cus = customerList.getAllCustomers();
//			Customer[] cus = customerList.getAllCustomers();
			for (int i = 0; i < customerList.getTotal(); i++) {
				System.out.println((i + 1) + "\t" + cus[i].getName() + "\t" + cus[i].getGender() + "\t"
						+ cus[i].getAge() + "\t" + cus[i].getPhone() + "\t" + cus[i].getEmail());
			}
		}
		System.out.println("------------------------客户列表完成------------------------");

	}

	public static void main(String[] args) {
		CustomerView view = new CustomerView();
		view.enterMainMenu();
	}
}
