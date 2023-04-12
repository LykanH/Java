package com.atguigu.exer;
/**
 * 
 * @Description 类的构造器的使用
 * @author muchen
 * @version
 * @date 2022年5月7日下午2:02:51
 *
 */
public class Text9 {
	public static void main(String[] args) {
		
		Text9_Person p1 = new Text9_Person(18,"Lihua");
//		p1.name = "LiHua";
		System.out.println(p1.name);
		System.out.println(p1.age);
	}
}

class Text9_Person{
	String name;
	int age;
//	int a = 18;
	public Text9_Person(int a,String n) {
		age = a;
		name = n;
	}
}