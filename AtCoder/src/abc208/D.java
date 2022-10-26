package abc208;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		
		long matrix[][] = new long[n + 1][n + 1];

		for(int i = 0; i < m; i++) {
			
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			matrix[a][b] = c;
		}
		
		long result = 0;
		
		long INF = 1_000_000_000_000_000_000L;
		
		//dp[i][j][k] : iからjまでk以下の街を経由して移動するコスト
		long dp[][][] = new long[n + 1][n + 1][n + 1];
		
		//どこの街も経由せずに直接移動するコストで初期化
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(i == j) {
					dp[i][j][0] = 0;
				}
				else if(matrix[i][j] != 0) {
					dp[i][j][0] = matrix[i][j];
				}
				else {
					dp[i][j][0] = INF;
				}
			}
		}
		
		for(int k = 1; k <= n; k++) {
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					//kまで経由できるときのiからjへの最短距離は
					//・kを経由しないパターン　・kを経由するパターン
					//のうち小さい方。いずれも既に計算済みの値を使える
					dp[i][j][k] = Math.min(dp[i][j][k - 1], dp[i][k][k - 1] + dp[k][j][k - 1]);
					
					if(dp[i][j][k] < INF) {
						result += dp[i][j][k];
					}
					//オーバーフロー対策（不要かも）
					else {
						dp[i][j][k] = INF;
					}
				}
			}
		}
		
		System.out.println(result);
	}
}

