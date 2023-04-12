package kmp;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 阿尔吉侬是一只聪明又慵懒的小白鼠，它最擅长的就是走各种各样的迷宫。
 * 今天它要挑战一个非常大的迷宫，研究员们为了鼓励阿尔吉侬尽快到达终点，就在终点放了一块阿尔吉侬最喜欢的奶酪。
 * 现在研究员们想知道，如果阿尔吉侬足够聪明，它最少需要多少时间就能吃到奶酪。
 * 迷宫用一个 R×C 的字符矩阵来表示。
 * 字符 S 表示阿尔吉侬所在的位置，字符 E 表示奶酪所在的位置，字符 # 表示墙壁，字符 . 表示可以通行。
 * 阿尔吉侬在 1 个单位时间内可以从当前的位置走到它上下左右四个方向上的任意一个位置，但不能走出地图边界。
 * 输入格式 第一行是一个正整数 T ，表示一共有 T 组数据。
 * 每一组数据的第一行包含了两个用空格分开的正整数 R 和 C ，表示地图是一个 R×C 的矩阵。
 * 接下来的 R 行描述了地图的具体内容，每一行包含了 C 个字符。字符含义如题目描述中所述。保证有且仅有一个 S 和 E。
 * 输出格式 对于每一组数据，输出阿尔吉侬吃到奶酪的最少单位时间。
 * 若阿尔吉侬无法吃到奶酪，则输出“oop!”（只输出引号里面的内容，不输出引号）。
 * 每组数据的输出结果占一行。
 * 数据范围 1<T≤10 , 2≤R,C≤200 
 * 输入样例： 
 * 3 
 * 3 4 
 * .S.. 
 * ###. 
 * ..E. 
 * 3 4 
 * .S.. 
 * .E.. 
 * .... 
 * 3 4
 * .S.. 
 * #### 
 * ..E. 
 * 输出样例： 5 1 oop!
 * @author LykanHyper
 *
 */
/**
 * bfs解决迷宫问题
 * @author LykanHyper
 *
 */
public class Main_7 {
	static final int N = 210;
	static char[][] map = new char[N][N];//存放迷宫地图
	static int[][] dis = new int[N][N];//存储起点到每个路径的长度
	static Loc start,end;
	static int R,C;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		while(T-- > 0) {
			R = scanner.nextInt();
			C = scanner.nextInt();
			for(int i = 0;i<R;i++) {
				map[i] = scanner.next().toCharArray();
			}
			for(int i =0;i<R;i++) {
				for(int j = 0;j<C;j++) {
					if(map[i][j]=='S') start=new Loc(i,j);
					if(map[i][j]=='E') end = new Loc(i,j);
				}
			}
			int result = dfs(start,end);
			if(result!=-1) System.out.println(result);
			else System.out.println("oop!");
		}
		
		scanner.close();
	}

	private static int dfs(Loc start, Loc end) {
		Queue<Loc> queue = new LinkedList<>();
		//将dis所有元素置为-1，表示未走过.
		for(int i = 0;i<N;i++) Arrays.fill(dis[i], -1);
		dis[start.x][start.y] = 0;
		queue.offer(start);
		
		int[] dx = new int[] {-1,0,1,0};
		int[] dy = new int[] {0,1,0,-1};
		while(queue.size()!=0) {
			Loc t = queue.poll();//取出队列首位元素，并删除
			for(int i =0;i<4;i++) {
				int x = t.x+dx[i],y= t.y+dy[i];
				if(x<0||x>=R||y<0||y>=C) continue;//出界
				if(map[x][y]=='#') continue;//墙壁
				if(dis[x][y]!=-1) continue;//之前已经遍历过
				
				dis[x][y] = dis[t.x][t.y] + 1;//能走到这一点则步数加1
				
				//在入队的时候判断是否找到重点，找到返回dis[x][y];
				if(end.x == x && end.y == y) return dis[x][y];
				//将新状态加入队尾
				queue.offer(new Loc(x, y));
			}
			
		}
		
		return -1;
	}
}

class Loc{
	int x;
	int y;
	public Loc(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}
