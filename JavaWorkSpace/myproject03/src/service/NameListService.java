package service;

import domain.Archhitect;
import domain.Designer;
import domain.Employee;
import domain.Equipment;
import domain.NoteBook;
import domain.PC;
import domain.Printer;
import domain.Programmer;

public class NameListService {
	private Employee[] employees;

	public NameListService() {
		super();
//		1、根据项目提供的Data类构建相应大小的employees数组
//		2、再根据Data类中的数据构建不同的对象，包括Employee、Programmer、Designer
//		和Architect对象，以及相关联的Equipment子类的对象
//		3、将对象存于数组中

		employees = new Employee[Data.EMPLOYEES.length];
		for (int i = 0; i < Data.EMPLOYEES.length; i++) {
			int data = Integer.parseInt(Data.EMPLOYEES[i][0]);

			int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
			String name = Data.EMPLOYEES[i][2];
			int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
			double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);
			Equipment equipment;
			
			switch (data) {
			case Data.EMPLOYEE: {
				
				employees[i] = new Employee(id, name, age, salary);
				break;
			}case Data.PROGRAMMER:{
				equipment = getEquipment(i);
				employees[i] = new Programmer(id, name, age, salary, equipment);
				break;
			}case Data.DESIGNER:{
				equipment = getEquipment(i);
				double bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
				employees[i] = new Designer(id, name, age, salary, equipment, bonus);
				break;
			}case Data.ARCHITECT:{
				equipment = getEquipment(i);
				double bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
				int stock = Integer.parseInt(Data.EMPLOYEES[i][6]);
				employees[i] = new Archhitect(id, name, age, salary, equipment, bonus, stock);
				break;
			}
			
			}
		}
	}

	/**
	 * 
	 * @Description 获得指定index上的员工设备
	 * @author muchen
	 * @date 2022年8月6日下午7:23:04
	 * @param i
	 * @return
	 */

	private Equipment getEquipment(int index) {
		// TODO Auto-generated method stub
		for (int i = 0; i < Data.EMPLOYEES.length; i++) {
			if (i == index) {
				int type = Integer.parseInt(Data.EQIPMENTS[i][0]);
				switch (type) {
				case Data.PC: {
					return new PC(Data.EQIPMENTS[i][1], Data.EQIPMENTS[i][2]);

				}
				case Data.NOTEBOOK: {
					return new NoteBook(Data.EQIPMENTS[i][1], Double.parseDouble(Data.EQIPMENTS[i][2]));
				}
				case Data.PRINTER: {
					return new Printer(Data.EQIPMENTS[i][1], Data.EQIPMENTS[i][2]);
				}

				}
			}
		}
		return null;
	}
	/**
	 * 
	 * @Description:获取当前所有员工信息
	 * @author muchen
	 * @date 2022年8月8日下午3:38:04
	 * @return
	 */
	public Employee[] getAllEmployees() {
		return employees;

	}
	/**
	 * 
	 * @Description：获取某个员工信息
	 * @author muchen
	 * @date 2022年8月8日下午3:43:51
	 * @param id
	 * @return
	 * @throws TeamException
	 */
	public Employee getEmployee(int id) throws TeamException {
		for(int i = 0;i < employees.length;i++) {
			if(i == (id - 1)) {
				return employees[i];
			}
		}
		throw new TeamException("找不到指定员工");
	}
}
