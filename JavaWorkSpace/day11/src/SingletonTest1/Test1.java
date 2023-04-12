package SingletonTest1;

public class Test1 {
	public static void main(String[] args) {
		sun sun1 = sun.getSun();
		sun sun2 = sun.getSun();
		System.out.println(sun1 == sun2);
	}
}

//饿汉式
class sun{
	
	private sun() {
		
	}
	
	private static sun sun1 = new sun();
	//制作一个public方法返回实例化类
	public static sun getSun() {
		return sun1;
	}
}