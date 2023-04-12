package lanqiao_exe;

import java.util.Iterator;

/**
 * 小蓝有一条玩具蛇，一共有 16 节，上面标着数字 1 至 16。每一节都是一 个正方形的形状。 相邻的两节可以成直线或者成 90 度角。 小蓝还有一个
 * 4× 4 的方格盒子， 用于存放玩具蛇，盒子的方格上依次标着 字母 A 到 P 共 16 个字母。
 * 小蓝可以折叠自己的玩具蛇放到盒子里面。他发现，有很多种方案可以将 玩具蛇放进去。 请帮小蓝计算一下，总共有多少种不同的方案。如果两个方案中，存在玩
 * 具蛇的某一节放在了盒子的不同格子里，则认为是不同的方案。
 * 
 * @author LykanHyper
 */
//每一格子都得遍历四个方位,必须用回溯解决
public class Main_E {
	static boolean[][] booles = new boolean[4][4];// true表示已经遍历过
	static int result = 0;
	static int[] dx = new int[] { 0, 1, 0, -1 };
	static int[] dy = new int[] { -1, 0, 1, 0 };

	public static void main(String[] args) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				booles[i][j] = true;
				backTracking(i, j, 0);
				booles[i][j] = false;
			}
		}
		System.out.println(result);
	}
	public static void backTracking(int x, int y, int index) {
		if (index == 15) {
			result++;
			return;
		}
		for (int i = 0; i < 4; i++) {
			int xi = x + dx[i], yi = y + dy[i];

			if (xi >= 0 && xi < 4 && yi >= 0 && yi < 4 && !booles[xi][yi]) {
				booles[xi][yi] = true;
				backTracking(xi, yi, index + 1);
				booles[xi][yi] = false;// 回溯
			}
		}
	}

}