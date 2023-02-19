package arraystackdemo;

//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 
 * @author LykanHyper
 * 
 *         数组栈的实现
 */
public class ArrayStackDemo {
	public static void main(String[] args) {
		ArrayStack aStack = new ArrayStack(2);
//		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		String judg = null;
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("1：入栈");
			System.out.println("2：出栈");
			System.out.println("3：遍历栈");
			System.out.println("4：退出程序");
			System.out.print("请输入你要操作的数字：");
			judg = scanner.next();
//			try {
//				judg = bReader.readLine();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} finally {
//				if (bReader != null) {
//					try {
//						bReader.close();
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
			switch (judg) {
			case "1": {
				System.out.print("输入你想插入的数值：");
				int num = scanner.nextInt();
//				int num = new Scanner(System.in).nextInt();
				aStack.push(num);
				System.out.println(num + "已入栈");
				break;
			}
			case "2": {
				try {
					int res = aStack.pop();
					System.out.println("出栈的数据是：" + res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			}
			case "3": {
				aStack.list();
				break;
			}
			case "4": {
				System.out.println("程序结束！");
				return;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + judg);
			}
		}
	}
}
