package domain;

import service.Status;

public class Designer extends Programmer {
	private double bonus;
	private Status status = Status.FREE;

	public Designer() {
		super();
	}

	public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
		super(id, name, age, salary, equipment);
		this.bonus = bonus;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return inforation() + "\t" + "设计师" + "\t" + getStatus() + "\t" + getBonus() + "\t\t" + this.getEquipment();
	}
	
	public String getDetailTeam() {
		return getMemberId() + "/" + getId() + "\t" + getName() + "\t" + getAge() + "\t" + getSalary() + "\t设计师\t" + getStatus() + "\t" + getBonus();
	}
}
