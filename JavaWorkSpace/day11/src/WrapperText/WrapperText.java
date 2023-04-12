package WrapperText;

import org.junit.Test;

/*
 * 包装类的使用：
 *1. Java中提供了八种基本数据类型对应的包装类，使得基本数据类型的变量具有类的特征
 * 
 *2. 掌握：基本数据类型、包装类、String三者之间的相互转换 
 */
public class WrapperText {
	
	@Test
	public void test5() {
		//String类型转化为基本数据类型、包装类。调用包装类的parseXxx(String s)
		
		String str1 = "123";
		
		int num2 = Integer.parseInt(str1);
		System.out.println(num2 + 1);
	}
	
	@Test
	public void test4() {
		//基本数据类型、包装类转化为String类型
		//调用String重载的valueOf(Xxx xxx)
		int num1 = 10;
		//方式一:连接运算
		String str1 = num1 + "";
		System.out.println(str1);
		//方式二：调用string的valueOf(Xxx xxx)
		float f1 = 1.23f;
		String str2 = String.valueOf(f1);
		System.out.println(str2);
		
		Float f2 = new Float(f1);
		String str3 = String.valueOf(f2);
		System.out.println(str3);
		
		int[] stu = new int[5];
	}
	
	//自动装箱与拆箱
	@Test
	public void test3() {
		
		//自动装箱：基本数据类型--->包装类
		int num2 = 10;
		Integer i1 = num2;
		
		boolean b1 = true;
		boolean b2 = b1;//自动装箱
		
		//自动拆箱:包装类--->基本数据类型
		System.out.println(i1.toString());
		
		int num3 = i1;//自动拆箱
		
	}
	
	//包装类装华为基本数据类型
	//	调用包装类xxx的xxxValue()
	@Test
	public void test2() {
		Integer int1 = new Integer(12);
		//若想让int1做加减运算则需将其转化为基本数据类型（此时为包装类）
		
		int i1 = int1.intValue();
		System.out.println(i1 + 1);
		
		Float f1 = new Float(12.3);
		float ff1 = f1.floatValue();
		System.out.println(ff1 + 1);
		
		
	}
	
	@Test
	public void test1() {
		int num1 = 10;
//		System.out.println(num1);
		Integer int1 = new Integer(num1);
		System.out.println(int1.toString());

		Integer int2 = new Integer("123");
		System.out.println(int2.toString());
		
		Float f1 = new Float(12.3f);
		Float f2 = new Float("112.3");
		System.out.println(f1);
		System.out.println(f2);
		
		Boolean b1 = new Boolean(true);		//true
		Boolean b2 = new Boolean("TrUe");	//true	
		Boolean b3 = new Boolean("TrUe123");	//false
		System.out.println(b3);
		
		
	}
	
}
