package abc262;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		long a[] = new long[n + 1];
		int mod = 998244353;
		
		for(int i = 1; i <= n; i++) {
			a[i] = sc.nextLong();
		}
		
		long result = 0;
		//O(N^4)で10^8程度になるが計算がシンプルなので一応間に合う。
		for(int i = 1; i <= n; i++) {
			//dp[j][k][l] : j番目の数字までの中からk個使ってmod i = lのパターン数。
			//これを外側でdp[i][j][k][l]のように作るとおそらくMLEになる。
			//iが異なる場合は結果の再利用をしないため3次元で行ける。
			long dp[][][] = new long[n + 1][n + 1][n];
			for(int j = 0; j <= n; j++) {
				for(int k = 0; k <= j; k++) {
					//0個選んで余りが0になるパターン数を便宜上1とする。
					if(k == 0) {
						dp[j][0][0] = 1;
						continue;
					}
					for(int l = 0; l < i; l++) {
						int tmp = (int)((a[j] + l)%i);
						
						//それぞれj番目の要素を使わない場合と使う場合のパターン数。
						dp[j][k][l] += dp[j - 1][k][l];
						dp[j][k][tmp] += dp[j - 1][k - 1][l];
						
						dp[j][k][l] %= mod;
						dp[j][k][tmp] %= mod;
					}
				}
			}
			
			result += dp[n][i][0];
			result %= mod;
		}
		
		System.out.println(result);
	}
}