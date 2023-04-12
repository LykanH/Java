package service;

import domain.Archhitect;
import domain.Designer;
import domain.Employee;
import domain.Programmer;

public class TeamService {
	private static int counter = 1;// 自动生成团队中唯一ID
	private final static int MAX_MEMBER = 5;// 团队中最大成员数
	private Programmer[] team = new Programmer[MAX_MEMBER];
	private int total = 0;// 记录团队成员实际人数

	/**
	 * 
	 * @Description 获取开发团队中的所有成员
	 * @author muchen
	 * @date 2022年8月16日下午2:31:31
	 * @return
	 */
	public Programmer[] getTeam() {
		Programmer[] team = new Programmer[total];
		for(int i = 0;i < total;i++) {
			team[i] = this.team[i];
			
		}
		
		return team;//此处返回的是团队中所有有效成员 不包括null
	}
	/**
	 * 
	 * @Description 团队中添加成员
	 * @author muchen
	 * @date 2022年8月16日下午2:31:58
	 * @param e
	 * @throws TeamException 
	 */
	public void addMember(Employee e) throws TeamException {
//		失败信息包含以下几种：
//		-成员已满，无法添加
//		-该成员不是开发人员,无法添加
//		-该员工已在本开发团队中
//		-该员工已是某团队成员
//		-该员正在休假,无法添加
//		-团队中至多只能有一名架构师
//		-团队中至多只能有两名设计师
//		-团队中至多只能有三名程序员
		
		//添加成员
		
		if(total > MAX_MEMBER) {
			throw new TeamException("成员已满，无法添加");
		}
		if(!(e instanceof Programmer)) {
			throw new TeamException("该成员不是开发人员,无法添加");
		}
		if(isExit(e)) {
			throw new TeamException("该员工已在本开发团队中");
		}
		
//		-该员工已是某团该队成员
//		-该员正在休假,无法添加
		Programmer p = (Programmer) e;
//		if(p.getStatus() != Status.FREE) {		//测试一下
//		}
		if("BUSY".equals(p.getStatus().getNAME())) {
			throw new TeamException("该员工已是某团该队成员");
		}else if("VOCATION".equals(p.getStatus().getNAME())) {
			throw new TeamException("该员正在休假,无法添加");
		}
		
		int[] num = getNumber();
		for(int i = 0;i < total;i++) {
			if(p instanceof Archhitect) {
				if(num[0] > 1) {
					throw new TeamException("团队中至多只能有一名架构师");
				}
			}
			if(p instanceof Designer) {
				if(num[1] > 2) {
					throw new TeamException("团队中至多只能有两名设计师");
				}				
			}
			if(p instanceof Programmer) {
				if(num[2] > 3) {
					throw new TeamException("团队中至多只能有三名程序员");
				}				
			}
		}
		
		team[total++] = p;
		//给p的属性赋值
		p.setMemberId(counter++);
		p.setStatus(Status.BUSY);
	}
	/**
	 * 
	 * @Description 获取team中各个身份成员数量
	 * @author muchen
	 * @date 2022年8月16日下午4:33:48
	 * @return
	 */
	public int[] getNumber() {
		int[] num = new int[3];
		Programmer[] team =  getTeam();
		for(int i = 0;i < team.length;i++) {
			if(team[i] instanceof Archhitect) {
				num[0]++;
			}else if(team[i] instanceof Designer) {
				num[1]++;
			}else if(team[i] instanceof Programmer) {
				num[2]++;
			}
		}
		
		return num;
		
	}
	
	/**
	 * 
	 * @Description 判断需插入的新成员是否已在团队之中
	 * @author muchen
	 * @date 2022年8月16日下午3:33:52
	 * @param e
	 * @return
	 */
	public boolean isExit(Employee e) {
		
		for(int i = 0;i < total;i++) {
			if(team[i].getId() == e.getId()) {
				return true;
			}
		}
		return false;
	}
	/**
	 * 
	 * @Description 删除团队中指定成员
	 * @author muchen
	 * @date 2022年8月16日下午2:33:09
	 * @param memberid
	 * @throws TeamException 
	 */
	public void removeMember(int memberId) throws TeamException {
		boolean flag = true;
		for(int i = 0;i < total;i++) {
			if(memberId == team[i].getMemberId()) {
				team[i].setStatus(Status.FREE);
				flag = false;
				for(int j = i;j < total - 1;j++) {
					team[j] = team[j+1];
				}
//				team[total - 1] = null;
//				total--;
				
				//写法二
				team[--total] = null;
			}
			
		}
		
		if(flag) {
			throw new TeamException("未找到指定员工");
		}
		
	}
}
