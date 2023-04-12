package domain;

import service.Status;

public class Archhitect extends Designer {
	private int stock;// 奖励的公司股票
	private Status status = Status.FREE;

	public Archhitect() {
		super();
	}

	public Archhitect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
		super(id, name, age, salary, equipment, bonus);
		this.stock = stock;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
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
		return inforation() + "\t" + "架构师" + "\t" + getStatus() + "\t" + this.getBonus() + "\t" + getStock() + "\t"
				+ this.getEquipment();

	}

	public String getDetailTeam() {
		return getMemberId() + "/" + getId() + "\t" + getName() + "\t" + getAge() + "\t" + getSalary() + "\t架构师\t"
				+ getStatus() + "\t" + getBonus() + "\t" + getStock();
	}

}
