package recursion;

import java.util.ArrayList;

/*
 *递归的基础应用
 */
public class Recursion {
	public static void main(String[] args) {
		System.out.println(math1(5));
		System.out.println(math2(30, 18));
	}
	
	//递归实现阶乘
	public static int math1(int num) {
		if (num == 1) {
			return num;
		}else {
			return math1(num-1)*num;
		}
	}
	//递归实现求取最大公约数 即辗转相除法
	public static int math2(int a,int b) {
//		if (a % b != 0) {
//			math2(b, a % b);			
//		}if (a % b == 0) {
//			return b;
//		}
		
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.size();
		if(b == 0){
            return a;
        }
        return math2(b,a % b);
	}
}
