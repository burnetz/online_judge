package abc248;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		
		int mod = 998244353;
		
		//和として取りうる値が小さいのでDPテーブルを作れる
		long dp[][] = new long[n + 1][n*m + 1];
		
		for(int i = 1; i <= m; i++) {
			dp[1][i] = 1;
		}
		
		for(int i = 2; i <= n; i++) {
			for(int j = 1; j <= k ; j++) {
				for(int l = 1; l <= m && l + j <= k; l++) {
					dp[i][j + l] += dp[i - 1][j];
					dp[i][j + l] %= mod;
				}
			}
		}
		
		long sum = 0;
		
		for(int i = 1; i <= k; i++) {
			sum += dp[n][i];
		}
		
		sum %= mod;
		System.out.println(sum);
	}
}
