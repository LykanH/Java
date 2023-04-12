package InnerClassTest;
/*
 * 类的内部成员之五：内部类
 * 1.Java中允许将一个类A生命在另一个类B中，则类A就是内部类，类B称为外部类
 * 
 * 2.内部类的分类：成员内部类（静态、非静态）vs 局部内部类（方法内、代码块内、构造器内）
 * 
 * 3.成员内部类
 * 		一方面，作为外部类的成员
 * 			> 可以调用外部类的结构
 * 			> 可以被static修饰(正常外部类不能被static修饰。static只能修饰外部类的属性、方法、代码块)
 * 			> 可以被四种不同的权限修饰
 *		
 * 		另一方面，作为一个类
 * 			> 类内可以定义属性、方法、构造器等
 * 			> 可以被final修饰，表示此类不能被继承，言外之意，不适用final，就可以被继承
 * 			> 可以被abstract修饰（抽象类：表示此类不能被实例化）
 * 
 * 4.关注三个问题
 * 4.1 如何实现实例化成员内部类的对象
 * 4.2 如何在成员内部类中区分调用外部类的机构
 * 4.3 开发中局部内部类的使用
 * 
 */
public class InnerClassTest {
	
	public static void main(String[] args) {
		//创建静态成员内部类的实例化对象
		Person.Dog dog1 = new Person.Dog(); 	
		dog1.show();
		
		//创建Bird实例（非静态的成员内部类）
//		Person.Bird bird1 = new Person.Bird();	//错误的
		
		Person p = new Person();
		Person.Bird bird1 = p.new Bird();
		bird1.sing();
	}
}

class Person{
	
	String name;
	int age;
	public void eat() {
		System.out.println("人可以吃饭");
	}
	
	//静态成员内部类
	static class Dog{
		String name;
		int age;
		
		public void show() {
			System.out.println("卡拉是条狗");
//			eat(); //Dog类为静态类 只能调用静态的属性和方法
		}
	}
	
	//非静态成员内部类
	final class Bird{
		private String  name;
		
		public Bird(){
			
		}
		
		public void sing() {
			System.out.println("我是一只鸟");
			Person.this.eat(); //调用外部类的非静态属性
		}
	}
	
	public Person(){
		//声名在构造器中的类
		class CC{
			
		}
	}
	
	public void method() {
		//局部内部类
		//声明在方法体中
		class AA{
			
		}
	}
	
	
	{
		//声明在代码块中
		class BB{
			
		}
	}
	
}
