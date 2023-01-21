package abc242;

import java.util.Arrays;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		long dp[][] = new long[n][10];
		int mod = 998244353;
		
		Arrays.fill(dp[0], 1);
		
		for(int i = 1; i < n; i++) {
			for(int j = 1; j <= 9; j++) {
				for(int k = Math.max(1, j - 1); k <= Math.min(9, j + 1); k++) {
					dp[i][j] += dp[i - 1][k];
				}
				dp[i][j] %= mod;
			}
		}
		
		long sum = 0;
		for(int i = 1; i <= 9; i++) {
			sum += dp[n - 1][i];
		}
		sum %= mod;
		
		System.out.println(sum);
	}
}