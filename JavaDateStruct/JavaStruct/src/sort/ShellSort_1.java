package sort;

import java.util.Scanner;

/*
 * 希尔排序的代码实现(通过交换式方法实现希尔排序<速度较慢>)
 * 移位式，即先保存需要移动元素的下标，如果小于则
 */
public class ShellSort_1 {
	public static void main(String[] args) {
		// 产生i个随机数
		Scanner scanner = new Scanner(System.in);
		System.out.print("输入产生多少个随机数进行排序：");
		int all = scanner.nextInt();
		int[] ints = new int[all];
		for (int i = 0; i < all; i++) {
			ints[i] = (int) (Math.random() * 100);
		}

//		System.out.println("排序前" + Arrays.toString(ints));

		long start = System.currentTimeMillis();
		
		ShellSort_1 shellSort_1 = new ShellSort_1();
		shellSort_1.shell(ints);
		
		long end = System.currentTimeMillis();
//		System.out.println("排序后" + Arrays.toString(ints)); 

		System.out.println("总耗时为：" + (end - start));
		scanner.close();
	}

	public void shell(int[] ints) {//使用移位法实现希尔排序核心算法和插入排序核心算法相似
		for(int gap = ints.length / 2;gap > 0;gap = gap/2) {
			for(int i = gap;i < ints.length;i++) {
				int num = i - gap;		//让num指向需要比较的值
				int tempNum = ints[i];	//暂时保存需要移位元素的值
				while(num >= 0 && tempNum < ints[num]) {
					ints[num + gap] = ints[num];
					num -= gap;
				}
				ints[num + gap] = tempNum;
			}
		}
	}
}
