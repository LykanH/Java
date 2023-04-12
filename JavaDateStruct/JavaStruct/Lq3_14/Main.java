import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;
/*
 * 10
 	-5 -7 -2 1 -9 -7 4 5 6 1
 */
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedInputStream(System.in));
		int N = scanner.nextInt();
		
		int[] nums = new int[N+1];
		int[] dp = new int[N+1];
		for (int i = 1; i <= N; i++) {
			nums[i] = scanner.nextInt();
		}
		
		Arrays.fill(dp, 1);
		
		int max=0,result=1;
		for(int i=2;i<=N;i++) {
			for(int j=1;j<i;j++) {
				if(nums[j]<nums[i]) {
					max = Math.max(max, dp[i]+dp[j]);
				}
			}
			dp[i] = dp[i]>max?dp[i]:max;
			result = Math.max(dp[i], result);
			max = 0;
		}
		System.out.println(result);
	}
}
