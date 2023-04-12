package com.muchen.extends_4;
/*
 * (5）定义PayrollSystem类，创建Employee变量数组并初始化，该数组存放各
 * 类雇员对象的引用。利用循环结构遍历数组元素，输出各个对象的类
	型,name,number,birthday,以及该对象生日。当键盘输入本月月份值时，
	如果本月是某个Employee对象的生日，还要输出增加工资信息。
 */
import java.util.Calendar;
import java.util.Scanner;

public class PayrollSystem {
	public static void main(String[] args) {
		Employee[] emp = new Employee[2];
		
		//方式一（获取当前月份）：
		System.out.println("请输入本月月份：");
		Scanner scan = new Scanner(System.in);
		int month = scan.nextInt();
		
		//方式二：
//		Calendar calendar = Calendar.getInstance();		//该月份从零开始（即1月份为0，二月份为1）
//		int month = calendar.get(Calendar.MONTH)+1;		//获取当前的月份
					
		
		emp[0] = new SalariedEmployee(30000, "zhangsan", 1001,new MyDate(2022, 6, 3));
		emp[1] = new HourlyEmployee(60, 240, 0, "lisi", 1002, new MyDate(2022, 4, 20));
		
		for(int i = 0;i < emp.length;i++) {
			System.out.println( emp[i].toString());
			System.out.println(emp[i].getName() + "薪资为：" + emp[i].earnings());
			if(emp[i].getBirthday().getMonth() == month) {
				System.out.println("生日快乐，加薪100元！");
			}
		}
	}
}
