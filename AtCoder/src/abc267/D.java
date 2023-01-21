package abc267;

import java.util.Arrays;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		long a[] = new long[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextLong();
		}
		
		//dp[i][j] : i番目まで見たときの長さjの部分列で計算した最大値
		long dp[][] = new long[n][m + 1];
		
		//最終的な値が負の可能性があるので十分小さい負数で初期化
		for(int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1_000_000_000_000_000L);
		}
		dp[0][1] = a[0];
		
		for(int i = 1; i < n; i++) {
			
			dp[i][1] = Math.max(dp[i - 1][1], a[i]);
			for(int j = 2; j <= m; j++) {
				dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + a[i]*j);
			}
		}
		
		long result = Long.MIN_VALUE;
		
		for(int i = 0; i < n; i++) {
			result = Math.max(result, dp[i][m]);
		}
		
		System.out.println(result);
	}
}