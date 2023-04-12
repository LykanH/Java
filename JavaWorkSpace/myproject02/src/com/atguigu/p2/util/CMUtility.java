package com.atguigu.p2.util;

import java.util.*;

public class CMUtility {
	private static Scanner scan = new Scanner(System.in);

	/*
	 * 用于用户在菜单界面的选择 ，读取键盘，如果用户输入"1-5"的任意字符，则方法返回 返回值作为用户选择的字符
	 */

	public static int readMenuSelection() {
		int a;
		a = scan.nextInt();
		for (;;) {
			if (a == 1 || a == 2 || a == 3 || a == 4 || a == 5) {
				break;
			} else {
				System.out.println("输入有误，请重新输入!");
				break;
			}
		}
		return a;
	}

	/*
	 * 从键盘读取一个字符并将其作为方法的返回值 如果用户不输入字符而直接输入
	 * 回车，方法以defaultValue作为返回值。
	 */

	public static char readChar() {
		String str = readKeyBoard(1, false);
		return str.charAt(0);
	}
	
	/*从键盘读取一个返回值并将其作为方法的返回值。
	 * 如果用户不输入字符而直接回车，方法将以defaultValue 作为返回值
	 */
	public static char readChara(char defaultValue) {
		String str = readKeyBoard(1, true);
		return (str.length() == 0 ? defaultValue : str.charAt(0));
		
	}
	
	/*从键盘读取一个长度不超过俩位数的整数，并将其作为方法的返回值。
	 * 年龄
	 */
	public static int readInt() {
		int n;
		for(;;) {
			String str = readKeyBoard(2, false);
			try {
				n = Integer.parseInt(str);
				break;
			}catch(NumberFormatException e) {
				System.out.println("数字输入错误，请重新输入：");
			}
		}
		return n;
	}
	
	/*从键盘读取一个长度不超过两位的整数，并将其作为方法的返回值。
	 * 如果用户不输入字符而直接回车，方法将以defaultValue作为返回值
	 */
	public static int readInt(int defaultValue) {
		int n;
		for(;;) {
			String str = readKeyBoard(2, true);
				if(str.equals("")) {
					return defaultValue;
				}
				try {
					n = Integer.parseInt(str);
					break;
				}catch (NumberFormatException e) {
					System.out.println("数字输入错误，请重新输入！");
				}
			}
		return n;
	}
	/*
	 * 从键盘读取一个长度不超过limit的字符串
	 * 并将其作为方法的返回值
	 */
	public static String readString(int limit) {
		return readKeyBoard(limit, false);
	}

	private static String readKeyBoard(int limit, boolean blankReturn) {
		// TODO Auto-generated method stub
		String line = "";
		while (scan.hasNextLine()) {
			line = scan.nextLine();
			if(line.length() == 0) {
				if(blankReturn) {
					return line;
				}else continue;
			}
			if(line.length() < 1 || line.length() > limit) {
				System.out.println("输入长度（不大于"+ limit +")错误，请从新输入！");
				continue;
			}
			break;
		}
		return line;

	}
}
