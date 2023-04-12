package lanqiao_exe;

import java.util.Scanner;

/**
 * L 星球上的生物由蛋蓝质组成，每一种蛋蓝质由一类称为蓝肽的物资首尾 连接成一条长链后折叠而成。 生物学家小乔正在研究 L
 * 星球上的蛋蓝质。她拿到两个蛋蓝质的蓝肽序列， 想通过这两条蓝肽序列的共同特点来分析两种蛋蓝质的相似性。 具体的，一个蓝肽可以使用 1 至 5
 * 个英文字母表示，其中第一个字母大写， 后面的字母小写。一个蛋蓝质的蓝肽序列可以用蓝肽的表示顺序拼接而成。
 * 在一条蓝肽序列中，如果选取其中的一些位置，把这些位置的蓝肽取出， 并按照它们在原序列中的位置摆放，则称为这条蓝肽的一个子序列。蓝肽的子
 * 序列不一定在原序列中是连续的，中间可能间隔着一些未被取出的蓝肽。 如果第一条蓝肽序列可以取出一个子序列与第二条蓝肽序列中取出的某个
 * 子序列相等，则称为一个公共蓝肽子序列。 给定两条蓝肽序列，找出他们最长的那个公共蓝肽子序列的长度。 【输入格式】
 * 输入两行，每行包含一个字符串，表示一个蓝肽序列。字符串中间没有空 格等分隔字符。
 * 
 * @author LykanHyper
 *
 */
public class Main_F {
	public static void main(String[] args) {
		int result = 0;
		Scanner scanner = new Scanner(System.in);
		String s1 = scanner.nextLine();
		String s2 = scanner.nextLine();
		char[] c1 = s1.toCharArray();
		
		
		StringBuffer ss = new StringBuffer();
		
		char[] temp = new char[6];
		int index = 0;//表示temp[] 当前下标
		for(int i=0;i<c1.length;i++) {
			temp[index++] = c1[i];
			if(i==c1.length-1||(c1[i+1]>='A'&&c1[i+1]<='Z')) {
				ss.append(temp,0,index);
				
				String string = ss.toString();
				System.out.println(string);
				
				System.out.println(s2.contains(string));
				if(s2.contains(string)) {
					result++;
				}
				index=0;
				ss = new StringBuffer();
				
				temp = new char[6];
			}
		}
		System.out.println(result);
		
		scanner.close();
	}

}
