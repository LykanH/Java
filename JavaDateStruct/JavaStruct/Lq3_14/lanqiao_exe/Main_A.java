package lanqiao_exe;

/**
 * 小蓝特别喜欢 2，今年是公元 2020 年，他特别高兴。
 * 他很好奇，在公元 1 年到公元 2020 年（包含）中，有多少个年份的数位中 包含数字 2？
 * 
 * @author LykanHyper
 *
 */
public class Main_A {
	public static void main(String[] args) {
		String tempString = null;
		int result = 0;
		for(int i = 1;i<=2020;i++) {
			tempString = i+"";
		
			if(tempString.contains("2")) result++;
		}
		System.out.println(result);
	}
}
