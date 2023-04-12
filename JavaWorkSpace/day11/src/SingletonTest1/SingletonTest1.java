package SingletonTest1;
/*
 * 单例设计模式
 * 所谓单例设计模式，就是采用一定的方法保证在整个的系统软件中，对某个类只能存在一个对象实例
 * 
 * 实现方法：①饿汉式
 * 			②懒汉式
 * 
 * 区分饿汉式和懒汉式
 * 饿汉式
 * 		坏处：对象加载时间过长
 * 		好处：饿汉式是线程安全的
 * 懒汉式
 * 		好处：延迟对象的创建
 * 		坏处：线程不安全  （到多线程可以修改加强）
 */
public class SingletonTest1 {
	public static void main(String[] args) {
//		Bank bank1 = new Bank();
//		Bank bank2 = new Bank();		//此不属于单例设计模式，所以必须私有化Bank的构造器
//		Bank bank3 = new Bank();
		
		Bank bank1 = Bank.getBank();
		Bank bank2 = Bank.getBank();
		System.out.println(bank1 == bank2);
		System.out.println(bank1.getName());
		System.out.println(bank2.getAddress());
	}
}
//饿汉式
class Bank{
	
	private String name;
	private String address;
	
	//1.私有化类的构造器
	private Bank(){
		name = "银行";
		address = "地址";
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	//2.内部类创建对象
	//4.要求此对象也必须声明为静态的
	private static Bank bank1 = new Bank();
	
	//3.提供公共的方法，返回单例化出来的对象
	public static Bank getBank() {
		return bank1;
	}
	
}
