package StaticText;

public class StaticText {
	public static void main(String[] args) {
		
		Chinese.nation = "CH";		//可以在实例化类之前对静态变量进行赋值
		
		Chinese c1 = new Chinese();
		c1.age = 18;
		c1.name = "zhangsan";
		c1.nation = "CHINA";
		
		Chinese c2 = new Chinese();
		c2.name = "lisi";
		c2.age = 20;
		System.out.println(c2.nation);		//静态变量在静态变量池中通用
		
		Chinese.show();				//直接用类来调用静态方法
	}
}


class Chinese{
	String name;
	int age;
	
	static String nation;		//定义静态变量，静态变量和类同时加载
	
	public static void show() {		//用static修饰方法，静态方法
		//随着类的加载而加载，可以通过"类.静态方法进行调用"
		System.out.println("我是一个中国人");
//		eat();						//在静态方法中只能调用静态的属性和方法
						//非静态方法中可以调用非静态的方法或属性，也可以调用静态方法和属性
						
		
	}
	public void eat() {
		System.out.println("吃饭！");
	}
	
}