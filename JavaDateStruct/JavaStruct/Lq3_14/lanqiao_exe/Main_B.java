package lanqiao_exe;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 小蓝在一张无限大的特殊画布上作画。 这张画布可以看成一个方格图，每个格子可以用一个二维的整数坐标表示。 
 * 小蓝在画布上首先点了一下几个点：(0, 0),
 * (2020, 11), (11, 14), (2000, 2000)。 只有这几个格子上有黑色，其它位置都是白色的。
 * 每过一分钟，黑色就会扩散一点。具体的，如果一个格子里面是黑色，它 就会扩散到上、下、左、右四个相邻的格子中，使得这四个格子也变成黑色
 * （如果原来就是黑色，则还是黑色）。 请问，经过 2020 分钟后，画布上有多少个格子是黑色的。
 * 
 * @author LykanHyper
 *
 */
//bfs宽搜
public class Main_B {
	static final int N = 10000;
	static int[][] dis = new int[N][N];//存放哪些点被遍历过
	static char[][] map = new char[N][N];
	static int[] dx = new int[] {0,1,0,-1};
	static int[] dy = new int[] {-1,0,1,0};
	
	public static void main(String[] args) {
		int res = 0; 
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i==3000&&j==3000) map[i][j] = '*';
				else if(i==5020&&j==3011) map[i][j] = '*';
				else if(i==3011&&j==3014) map[i][j] = '*';
				else if(i==5000&&j==5000) map[i][j] = '*';
				else map[i][j]='.';//将坐标系上的黑点记为*，白点记为.
			}
		}
		bfs();
		for(int i = 0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]=='*') {
					res++;
				}
			}
		}
		
		System.out.println(res);
	}

	private static void bfs() {
		for(int i=0;i<N;i++) Arrays.fill(dis[i], -1);//将距离数组全部记为-1；即未遍历过
		dis[3000][3000] = 0;
		dis[5020][3011] = 0;
		dis[3011][3014] = 0;
		dis[5000][5000] = 0;
		Queue<Pii> queue = new LinkedList<Pii>();
		queue.offer(new Pii(3000, 3000));
		queue.offer(new Pii(5020, 3011));
		queue.offer(new Pii(3011, 3014));
		queue.offer(new Pii(5000, 5000));
		while(queue.size()!=0) {
			Pii temp = queue.poll();
			
			if(dis[temp.x][temp.y]==2020) return;
			
			for(int i=0;i<4;i++) {
				int a=temp.x+dx[i],b=temp.y+dy[i];
				if(map[a][b]=='*') continue;//已经是黑色
				if(dis[a][b]!=-1) continue;//已经走过
				if(a < 0 || a > 10000 || b < 0 || b > 10000) continue;
				
				map[a][b] = '*';
				dis[a][b]=dis[temp.x][temp.y]+1;
				queue.offer(new Pii(a, b));
			}
		}
		
	}
}
class Pii {
	//创建一个类用于存放棋盘坐标
	int x;
	int y;
	public Pii(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}
