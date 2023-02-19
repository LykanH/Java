package day01;

//import java.util.Iterator;

//八皇后问题代码实现，（递归回溯算法）
public class Queen8 {
	final int MAX = 8;//MAX为需要摆放皇后的数量
	static int count = 0;//保存共有几种可能
	int[] array = new int[MAX];				//用来存放具体每个解中8个皇后摆放的位置；
	public static void main(String[] args) {
		Queen8 queen8 = new Queen8();
		queen8.check(0);
		System.out.println(count);
	}
	
	public void check(int n) {	//以n为标志点
		if(n == MAX) {
			print();
			return;
		}
		for(int i = 0;i < MAX;i++) {
			array[n] = i;
			if (judge(n)) {
				check(n + 1);
			}
		}
	}
	
	
	public boolean judge(int n) {
		/**
		 * 判断皇后位置是否冲突
		 * array[n] == array[i] 判断两个皇后是否在同一列
		 * Math.abs(n - i) == Math.abs(array[i] - array[n])	判断两个皇后是否在同一个对角线上,
		 * 	(可以看作判断其 两条边和其连线是否为等腰三角形，如果是等腰三角形，则说明两个皇后在同一条对角线上)
		 */
		for(int i = 0;i < n;i++) {
			if (array[n] == array[i] || Math.abs(n - i) == Math.abs(array[i] - array[n])) {
				return false;
			}
		}
		return true;
	}
	
	public void print() {
		count++;
		for(int i = 0;i< MAX;i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
