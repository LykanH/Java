package junit;

import java.util.Scanner;

import org.junit.Test;

import domain.Employee;
import service.NameListService;
import service.TeamException;
import service.Data;

public class Test1 {
	
	@Test
	public void allTest() {
		NameListService test = new NameListService();
		Employee[] employees = test.getAllEmployees();
		for(int i = 0;i < employees.length;i++) {
			System.out.println(employees[i].toString());
		}
	}
	
	@Test
	public void singleTest() {
		NameListService test2 = new NameListService();
		System.out.println("请输入需要查询人员的id");
		Scanner scan = new Scanner(System.in);
		int id = scan.nextInt();   //11  10
 		int i;
		try {
			for(i = 0;i < Data.EMPLOYEES.length;i++) {
				if((i + 1) == id) {
					System.out.println(test2.getEmployee(i));
					return;
				}
			}
			System.out.println(i);
			if( i != id) {
				throw new TeamException("输入的id不存在，请重新输入");
			}
		}catch(TeamException e) {
			System.out.println(e.getMessage());
		}
	}
}