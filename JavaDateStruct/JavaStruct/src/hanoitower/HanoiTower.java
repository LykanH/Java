package hanoitower;

/**
 * 
 * @author LykanHyper
 * 汉诺塔问题实现过程
 * 体现出了分治算法的思想，归并排序也体现出了分治算法的思想
 */

public class HanoiTower {
	public static void main(String[] args) {
		new HanoiTower().hanoi(5, 'a', 'b', 'c');
		
	}
	
	
	
	/**
	 * 
	 * @param num 汉诺塔方块的个数
	 * @param a 第一个柱子
	 * @param b
	 * @param c
	 */
	//汉诺塔问题实现
	public void hanoi(int num,char a,char b,char c) {
		if (num == 1) {		//如果只有一个塔 则直接将其从a移动到c即可
			System.out.printf("第%d个盘从%c移动到%c",num,a,c);
			System.out.println("****");
		}else {
			//如果超过两个盘，则将其分为两个部分 第一层为：1-num-1
			//第二层为：num		（即第二层只有一个盘）
			
			//1.先将a上边1到num-1个盘通过c移动到b
			hanoi(num - 1, a, c, b);
			//2.将第二层唯一一个方块移到c
			System.out.printf("第%d个盘从%c移动到%c*********\n",num,a,c);
			//3.将b层的num-1个盘全部移动到c盘上
			hanoi(num - 1, b, a, c);
		}
	}
}
