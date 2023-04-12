package exceptiontest;

import java.util.Date;
import java.util.Scanner;

import org.junit.Test;

/*
 * 异常体系结构
 * 
 * java.lang.Trowble
 * 		>java.lang.error:一般不编写针对性的代码进行处理
 * 		>java.lang.Exception:可以进行一场的处理
 * 				>编译时异常(checked)(受检异常)
 * 					IOException
 * 						FileNotFoundException
 * 					ClassNotFoundException
 * 				>运行时异常(unchecked)
 * 					NullPointerException(空指针异常)
 * 					ArrayIndexOutOfBoundsException(数组越界异常)
 * 					ClassCastException(类型转换异常)
 * 					NumberFormatException()
 * 					InputMismatchException(输入类型异常)
 * 					ArithmeticException(算数异常)
 */
public class ExceptionTest {
	@Test
	public void test1() {
		//NullPointerException
		String[] str = new String[] {"a","b"};
		str = null;
//		int[] arr = new int[] {1,2,3};
		System.out.println(str[1]);
	}
	@Test
	public void test2() {
		//ArrayIndexOutOfBoundsException
//		int[] a = new int[3];
//		System.out.println(a[3]);
		String str = "abc";
		System.out.println(str.charAt(3));	//StringIndexOutOfBoundsException 字符串越界异常
	}
	
	@Test
	public void test3() {
		//ClassCastException
		Object obj = new Date();
		String str = (String)obj;
	}
	
	@Test
	public void test4() {
		//NumberFormatException
		String str = "123";
		str = "abc";	//从String转换不到int类型，且报错
		int num = Integer.parseInt(str);
		System.out.println(num);
	}
	
	@Test
	public void test5() {
		//InputMismatchException
		Scanner scan = new Scanner(System.in);
		int score = scan.nextInt();
		System.out.println(score);
	}
	
	@Test
	public void test6() {
		//ArithmeticException
		int a = 10;
		int b = 0;
		System.out.println(a/b);
	}
}
