package exceptiontest;

import org.junit.Test;

public class ExceptionTest2 {
	@Test
	public void Test1() {
//		ClassNotFoundException
		
	}
	@Test
	public void Test2() {
		String str = new String();
		str = "abc";
		str = "123";
		System.out.println("str" + " = " + str);
	}
}
