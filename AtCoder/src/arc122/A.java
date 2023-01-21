package arc122;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		long a[] = new long[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		if(n == 1) {
			System.out.println(a[0]);
			return;
		}
		int mod = 1_000_000_007;
		long dp[][] = new long[n + 1][2];
		dp[0][0] = dp[0][1] = 1;
		
		for(int i = 1; i <= n ; i++) {
			dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
			dp[i][1] = dp[i - 1][0];
			
			dp[i][0] %= mod;
			dp[i][1] %= mod;
			
		}
		
		long dpSum[][] = new long[n][2];
		dpSum[0][0] = a[n - 1];
		dpSum[0][1] = mod -a[n - 1];
		for(int i = 1; i < n; i++) {
			dpSum[i][0] = (dpSum[i - 1][0] + dpSum[i - 1][1] + a[n - 1 - i]%mod * dp[i][0])%mod;
			dpSum[i][1] = (dpSum[i - 1][0] + (mod - (a[n - 1 - i]%mod)) * dp[i][1])%mod;
			
		}
		System.out.println(dpSum[n - 1][0]);
		
	}
}