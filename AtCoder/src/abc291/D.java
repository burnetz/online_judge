package abc291;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a[] = new int[n];
		int b[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		
		int mod = 998244353;
		
		//dp[i][j] : i枚目がjで作れるパターン数（j = 0 : 表　j = 1 : 裏）
		long dp[][] = new long[n][2];
		dp[0][0] = dp[0][1] = 1;
		
		for(int i = 1; i < n; i++) {
			if(a[i - 1] != a[i]) {
				dp[i][0] += dp[i - 1][0];
			}
			if(b[i - 1] != a[i]) {
				dp[i][0] += dp[i - 1][1];
			}
			if(b[i - 1] != b[i]) {
				dp[i][1] += dp[i - 1][1];
			}
			if(a[i - 1] != b[i]) {
				dp[i][1] += dp[i - 1][0];
			}
			
			dp[i][0] %= mod;
			dp[i][1] %= mod;
		}
		
		System.out.println((dp[n - 1][0] + dp[n - 1][1])%mod);
	}
}