package com.atguigu.p2.service;

import com.atguigu.p2.bean.Customer;

public class CustomerList {
	// 属性
	private Customer[] customers; // 用来保存客户对象的数组
	private int total;// 记录已保存用户的数量

	// 构造器
	public CustomerList(int totalCustomer) {
		customers = new Customer[totalCustomer];
	}

	// 方法：添加指定的客户到数组中
	public boolean addCustomer(Customer customer) {
		if (customers.length > total) {
			customers[total++] = customer;
			return true;
		} else {
			return false;
		}
	}

	// 方法：修改指定位置上的客户信息
	public boolean replaceCustomer(int index, Customer cus) {
		if (index >= 0 && index < total) {
			customers[index] = cus;
			return true;
		} else {
			return false;
		}
	}

	// 删除客户
	public boolean deleteCustomer(int index) {
		if (index >= 0 && index < total) {
			for (int i = index; i < total - 1; i++) {
				customers[index] = customers[index + 1];
			}
			customers[total - 1] = null;
			total--;
//			或
//			customers[--total] = null;
			System.out.println("删除" + (index + 1) + "号客户成功！");
			return true;
		} else {
			return false;
		}
	}

	// 获取所有客户信息
	public Customer[] getAllCustomers() {
		
		/*return customers;   不能，因为customers中可能还存在空值，
		 * 而方法要得到只含有用户信息的一个数组
		 */
		Customer[] custs = new Customer[total];
		for(int i = 0;i < total;i++) {
			custs[i] = customers[i];   //赋的只是一个地址 数组custs和customers中均为数组对象的地址
		}
		return custs;
		
	}

	// 获取指定客户信息
	// 如果找到元素，则返回元素，未找到返回null
	public Customer getCustomer(int index) {
		if(index >= 0 && index < total) {
			return customers[index];
		}
		return null;
	}

	//
	public int getTotal() {
		return total;
	}
}
