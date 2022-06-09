package abc253;

import java.util.Scanner;

public class E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		
		int mod = 998244353;
		
		//dp[i][j] : 長さiで最後の要素がj以下であるパターンの合計
		long dp[][] = new long[n][m + 1];
		
		for(int i = 1; i <= m; i++) {
			dp[0][i] = i;
		}
		
		//基本的な考え方はi番目の要素がjであるパターン数を計算してDPで求める。
		//ただしその方法だとO(NM^2)になるのでi番目の要素がj以下のときの累積和を計算する。
		//これにより上に離れているパターンも下に離れているパターンもO(1)で計算できる。
		for(int i = 1; i < n; i++) {
			for(int j = 1; j <= m; j++) {
				//k=0のときは後述の計算式が使えないので特別扱い
				if(k == 0) {
					dp[i][j] = (dp[i][j - 1] + dp[i - 1][m])%mod;
					continue;
				}
				long lowerSum = dp[i - 1][Math.max(0, j - k)];
				long upperSum = dp[i - 1][m] - dp[i - 1][Math.min(m, j + k - 1)] + mod;
				
				dp[i][j] = (lowerSum + upperSum + dp[i][j - 1])%mod;
				
			}
		}
		
		System.out.println(dp[n - 1][m]);
		
	}		
}

