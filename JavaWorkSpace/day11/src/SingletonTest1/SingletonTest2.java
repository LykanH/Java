package SingletonTest1;
//单例模式懒汉式实现
public class SingletonTest2 {
	public static void main(String[] args) {
		Order o1 = Order.getInstance();
		Order o2 = Order.getInstance();
		System.out.println(o1 == o2);
	}
}

//懒汉式
class Order{
	
	private Order() {
		
	}
	
	private static Order instance = null; 		//饿汉式和懒汉式的差别
	
	public static Order getInstance() {
		if(instance == null) {
			instance = new Order();		//如果不加if，则每执行一次getInstance()
										//方法就创建一个新的对象，不符合单例模式			
		}
		return instance;
	}
}

