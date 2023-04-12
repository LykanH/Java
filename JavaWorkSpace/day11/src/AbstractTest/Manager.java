package AbstractTest;

public class Manager extends Employee{
	private int bonus;
	
	public Manager(int bonus,String name,int age,int salary) {
		super(name,age,salary);
		this.bonus = bonus;
		
		
	}
	public void work() {
		System.out.println("我在工作！");
	}
	public String people() {
		return this.getName() + "的薪资为：" + this.getSalary() + 
				"年龄为" + this.getAge() + "奖金为：" + this.bonus;
	}
	
}
