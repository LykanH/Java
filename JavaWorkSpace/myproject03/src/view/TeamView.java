package view;

import java.util.Scanner;

import domain.Employee;
import domain.Programmer;
import service.NameListService;
import service.TeamException;
import service.TeamService;

public class TeamView {
	private NameListService listSvc = new NameListService();
	private TeamService teamSvc = new TeamService();
	
	public void enterMainMenu(){
		boolean loopFlag = true;
		listAllEmployees();
		while(loopFlag	) {
//			listAllEmployees();
			System.out.print("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择(1-4):");
			char menu = TSUtility.readMenuSelection();
			switch(menu) {
			case '1':{
				getTeam();
				break;
			}
			case '2':{
				addMember();
				listAllEmployees();
				break;
			}
			case '3':{
				deleteMember();
				listAllEmployees();
				break;
			}
			case '4':{
				System.out.print("确认是否退出(y/n):");
				char confirm = TSUtility.readConfirmSelection();
				if(confirm == 'Y') {
					loopFlag = false;					
				}
				listAllEmployees();
				break;
			}
			}
		}
	}
	/**
	 * 
	 * @Description 显示所有员工信息
	 * @author muchen
	 * @date 2022年8月16日下午5:46:19
	 */
	private void listAllEmployees() {
		System.out.println("----------------------------------开发团队调度软件---------------------------------\n");
		Employee[] employees = listSvc.getAllEmployees();
		if(employees == null || employees.length == 0) {
			System.out.println("没有任何成员信息！");
		}else {
			System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
			
			for(int i = 0;i < employees.length;i++) {
				System.out.println(employees[i]);
			}
		}
		System.out.println("---------------------------------------------------------------------------------\n");

		
	}
	private void getTeam() {
		Programmer[] employees =  teamSvc.getTeam();
		System.out.println("-------------团队成员列表-------------");
		if(employees.length == 0) {
			System.out.println("开发团队目前没有成员\n");
		}else {
			System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票");
			for(int i = 0;i < employees.length;i++) {
				System.out.println(employees[i].getDetailTeam());
			}			
		}
		System.out.println("--------------------------------");
	}
	private void addMember() {
		Employee[] employees = listSvc.getAllEmployees();
		System.out.println("-------------添加成员-------------");
		System.out.println("输入要插入员工的ID：");
//		Scanner scan = new Scanner(System.in);
//		int i = scan.nextInt();
		int i = TSUtility.readInt();
		try {
			Employee emp = listSvc.getEmployee(i);
			teamSvc.addMember(emp);		
			System.out.println("添加成功！");
		}catch(TeamException e){
			System.out.println("添加失败，原因：" + e.getMessage());
		}
		//按回车键继续
		TSUtility.readReturn();
	}
	private void deleteMember() {
		System.out.println("-------------删除成员-------------");
		System.out.println("请输入需要删除员工的TID");
		int memberId = TSUtility.readInt();
		System.out.print("确认是否删除(y/n):");
		char isDetal = TSUtility.readConfirmSelection();
		if(isDetal == 'N') {
			return;
		}
		try {
			teamSvc.removeMember(memberId);
			System.out.println("删除成功！");
		} catch (TeamException e) {
			// TODO Auto-generated catch block
			System.out.println("删除失败，原因：" + e.getMessage());
		}
		TSUtility.readReturn();
}
	
	public static void main(String[] args) {
		TeamView team = new TeamView();
		
		team.enterMainMenu();
		
	}
	
}
