package exceptiontest;
/*
 * try-catch-finally 模型
 * try{
 * 		可能出现异常的代码
 * }catch(异常类型 变量名1){
 * 		处理异常的方法
 * }catch(异常类型 变量名2){
 * 		处理异常的方法
 * }catch(异常类型 变量名3){
 * 		处理异常的方法
 * }...
 * finally{
 * 		//
 * }
 * 
 * 1.finally是可选可不选的
 * 2.使用try将可能出现异常的代码包起来，在执行过程中，一旦出现异常就会生成一个对应异常类的对象
 *   根据此对象的类型  去catch中匹配相应的异常
 * 3.匹配到之后，就进入catch中进行异常处理，一旦处理完成就跳出当前catch结构(没有finally)
 * 继续执行其后的代码。其他catch不执行
 * 4.catch 中的异常类型如果没有父子关系，谁声明在上或下无所谓
 * 	 catch 中异常类型如果有父子关系，则要求子类必须声明在父类的上面，否则报错
 * 5.常用异常处理的方式：①String getMessage()      ②printStackTrace()
 * 6.在try中声明的变量如果出了try的大括号以后，就不能再被调用
 * 
 * 
 * 体会1.使用try—catch-finally处理编译时异常，使程序在编译时不在报错，但是运行时仍可能报错
 * 		 相当于我们使用try-catch-finally将一个编译时可能出现的异常，延迟到运行时出现
 * 
 * 体会2.开发中 由于运行时异常比较常见，所以我们就不针对运行时异常编写try-catch-finally了，
 * 	      
 */

import org.junit.Test;

public class ExceptionTest1 {
	@Test
	public void Test1() {
//		String[] str = new String[] {"a","b","c"};
		String str = "123";
//		System.out.println(str[0]);
		str = "abc";
		try {
			int num = Integer.parseInt(str);
			System.out.println("hello1");	//上一行代码报错 这行代码不执行，直接执行catch
		}
		catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("出现数值转换异常了，请不要急");
			System.out.println("hello2");
		}
		catch (ClassCastException e) {
			// TODO: handle exception
			System.out.println("出现类型转换异常了，请不要急");
			System.out.println("hello3");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("出现异常了，请不要急");
		}
//		finally {
//			sys
//		}
		
		
	}
	
	
}
