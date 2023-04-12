package AbstractTest;
/*
 * abstract 关键字的使用
 * abstract可以用来修饰的结构：类、方法
 * 
 * abstract 修饰类：抽象类
 * 1.此类不能实例化
 * 2.抽象类中一定有构造器，便于子类实例化时调用（涉及：子类实例化全过程）super()关键字
 * 3.开发中，都会提供抽象的子类，让子类对象实例化，完成相关的操作
 * 
 * abstract 修饰方法
 * 1.抽象方法只有方法的声明，没有方法体
 * 2.包含抽象方法的类，一定是一个抽象类。反之，抽象类中可以没有抽象方法
 * 3.若子类重写了父类所有的抽象方法后，此子类可以实例化
 * 	 若子类没有重写父类中所有的抽象方法，则子类也是一个抽象类，需要使用abstract修饰
 * 
 * abstract使用上的注意点
 * 1.abstract不能用来修饰属性、构造器
 * 2.abstract不能用来修饰私有方法、静态方法、final方法(不能被重写)、final的类(不能被继承)
 */

public class AbstractTest {
	public static void main(String[] args) {
//		People p1 = new People();
//		People p2 = new People("zhangsan",18);
//		p1.walk();
	}
}

abstract class People{			//抽象类
	private String name;
	private int age;
	
	public People() {
		
	}
	public People(String name,int age) {
		this.name = name;
		this.age = age;
	}
	public abstract void shut();		//抽象方法 
	public void walk() {
		System.out.println("人走路");
	}
	public void eat() {
		System.out.println("人吃饭");
	}
}

class Man extends People{		//子类继承抽象类后，若父类中含有抽象方法的话，
								//则子类会继承抽象方法。若不做修改则会报错(含有抽象方法的类一定是抽象类)
								//1.重写父类中的抽象方法
								//2.将子类也修改为抽象方法
	
	public void shut() {
		System.out.println("人可以说话");		//方法一
	}
	
}
