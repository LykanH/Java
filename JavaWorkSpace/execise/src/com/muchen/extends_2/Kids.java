package com.muchen.extends_2;

public class Kids extends ManKind{
	private int yearsOld;
	
	public void printAge() {
		System.out.println("yearOld:" + getYearsOld());
	}

	public int getYearsOld() {
		return yearsOld;
	}

	public void setYearsOld(int yearsOld) {
		this.yearsOld = yearsOld;
	}
	
}
