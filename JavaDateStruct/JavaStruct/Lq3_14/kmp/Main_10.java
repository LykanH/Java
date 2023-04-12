package kmp;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 给定一个 n×m 的二维整数数组，用来表示一个迷宫，数组中只包含 0 或 1 ，其中 0 表示可以走的路，1 表示不可通过的墙壁。
 * 
 * 最初，有一个人位于左上角 (1,1) 处，已知该人每次可以向上、下、左、右任意一个方向移动一个位置。
 * 
 * 请问，该人从左上角移动至右下角 (n,m) 处，至少需要移动多少次。
 * 
 * 数据保证 (1,1) 处和 (n,m) 处的数字为 0 ，且一定至少存在一条通路。
 * 
 * 输入格式 第一行包含两个整数 n 和 m 。
 * 
 * 接下来 n 行，每行包含 m 个整数（0 或 1 ），表示完整的二维数组迷宫。
 * 
 * 输出格式 输出一个整数，表示从左上角移动至右下角的最少移动次数。
 * 
 * 数据范围 1≤n,m≤100
 * 
 * 输入样例： 5 5
 * 
 * 0 1 0 0 0
 * 
 * 0 1 0 1 0
 * 
 * 0 0 0 0 0
 * 
 * 0 1 1 1 0
 * 
 * 0 0 0 1 0
 * 
 * 输出样例： 8
 * 
 * @author LykanHyper
 *
 */
//bfs解决迷宫问题
public class Main_10 {
	static final int K = 101;
	static int[][] map = new int[K][K];
	static int[][] dis = new int[K][K];// 创建距离数组记录到达某一点的最短路径初始值均为-1，即没有走过

	static int[] dx = new int[] { -1, 0, 1, 0 };// 四个方向的偏移量
	static int[] dy = new int[] { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = scanner.nextInt();// 创建二维数组存放迷宫图
			}
		}
//		for(int i=0;i<n;i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}

		bfs(m, n);
		
		System.out.println(dis[n-1][m-1]);
	}

	private static void bfs(int m, int n) {
		for (int i = 0; i < K; i++)
			Arrays.fill(dis[i], -1);

		dis[0][0] = 0;// 表示起始位置已经走过
		Queue<Pii> queue = new LinkedList<Pii>();
		queue.offer(new Pii(0, 0));

		while (queue.size() != 0) {
			Pii head = queue.poll();

			for (int i = 0; i < 4; i++) {
				int x = head.x + dx[i];
				int y = head.y + dy[i];
				if (x < 0 || x >= n || y < 0 || y >= m)
					continue; // 出界
				if (dis[x][y] != -1)
					continue;// 已经走过
				if (map[x][y] == 1)
					continue;// 遇到墙壁

				queue.offer(new Pii(x, y));
				dis[x][y] = dis[head.x][head.y] + 1;
				
				if(x==(m-1) && y==(n-1)) return;
			}
		}
	}

}

class Pii {
	int x;
	int y;

	public Pii(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}
