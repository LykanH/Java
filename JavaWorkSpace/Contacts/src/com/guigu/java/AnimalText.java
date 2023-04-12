package com.guigu.java;
/**
 * 
 * @Description 封装与隐藏
 * @author muchen
 * @version
 * @date 2022年5月6日下午3:43:25
 *
 */
public class AnimalText {
	public static void main(String[] args) {
		animal a = new animal();
		a.name = "花花";
//		a.age = 16;
		a.setAge(8);
		System.out.println("动物年龄为：" + a.getAge());
		
		a.setLegs(4);
//		a.legs = 6;
		a.print();
//		System.out.println("a动物的腿数量：" + a.legs);    //legs私有，不能调用
														//在其父类中创建方法返回数值
		System.out.println("a动物腿数量：" + a.getLegs());
	}
}


//定义一个动物类
class animal{
	String name;
	private int age;
	public void setAge(int a) {
		if(a > 0) {
			this.age = a;
		}else {
			this.age = 0;
		}
	}
	
	public int getAge() {
		return this.age;
	}
	
	private int legs;			//腿的数量不能为负值(定义一个方法控制legs的赋值)
								//private 将其限制为只有本身类可以调用的方法
								//即在main方法中不能给legs属性赋值
	public void setLegs(int l) {
		if(l > 0 && l % 2 == 0) {
			this.legs = l;
		}else {
			this.legs = 0;
		}
	}
	public int getLegs() {
		return legs;
	}
	
	public void print() {
		System.out.println("他的名字：" + this.name + "年龄：" + 
		this.age + "腿数量：" + this.legs);
	}
}