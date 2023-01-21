package abc220;

import java.util.Arrays;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		
		//dp[i][j]: aiまでで加算乗算問わず1の位をjにできるパターン数
		long dp[][] = new long[n][10];
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		dp[0][a[0]%10] = 1;
		
		int mod = 998244353;
		
		//加算も乗算も共にmodで考えても結果が変わらないので同時に考えて大丈夫
		for(int i = 1; i < n; i++) {
			for(int j = 0; j <= 9; j++) {
				dp[i][j*a[i]%10] += dp[i - 1][j];
				dp[i][j*a[i]%10] %= mod;
				dp[i][(j + a[i])%10] += dp[i - 1][j];
				dp[i][(j + a[i])%10] %= mod;
			}
		}
		
		for(int i = 0; i <= 9; i++) {
			System.out.println(dp[n - 1][i]);
		}
	}

}
