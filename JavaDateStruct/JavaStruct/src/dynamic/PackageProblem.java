package dynamic;


/*
 * 0 1 背包问题的实现
 * 
 */
public class PackageProblem {
	public static void main(String[] args) {
		int[] val = new int[] {1500,3000,2000};//商品的价值
		int[] w = new int[] {1,4,3};//商品重量
		int size = 4;//背包可承受最大重量
		int[][] v = new int[w.length + 1][size + 1];
		
		//for循环将第一行和第一列的值均设置为0;可以不设置 因为默认为0
		for(int i = 0;i < v.length;i++) {
			for(int j = 0;j < v[0].length;j++) {
				if (i == 0||j == 0) {
					v[i][j] = 0;
				}
			}
		}
		
		
		for(int i = 1;i < v.length;i++) {
			for(int j = 1;j < v[0].length;j++) {
				if (j < w[i - 1]) {
					v[i][j] = v[i - 1][j];
				}else {
					v[i][j] = Math.max(v[i-1][j],val[i-1]+v[i-1][j-w[i-1]]);
				}
			}
		}
		
		
		for(int i = 0;i < v.length;i++) {
			for(int j = 0;j < v[0].length;j++) {
				System.out.print(v[i][j] + " ");
			}
			System.out.println();
		}
	}
}
