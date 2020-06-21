package abc021;

import java.util.Scanner;

public class C {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		final int mod = 1_000_000_007;

		int a = sc.nextInt() - 1;
		int b = sc.nextInt() - 1;

		int m = sc.nextInt();

		boolean input[][] = new boolean[n][n];

		for(int i = 0; i < m; i++){
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;

			input[x][y] = input[y][x] = true;
		}

		//dp[i][j] : iターンでjに行くパターン数
		long dp[][] = new long[n + 1][n];
		dp[0][a] = 1;

		//最短距離は最悪でもNなのでO(N^3)でパターンの計算が可能
		for(int i = 1; i <= n; i++){
			for(int j = 0; j < n; j++){
				for(int k = 0; k < n; k++){
					if(input[j][k]){
						dp[i][j] += dp[i - 1][k];
						dp[i][j] %= mod;
					}
				}
			}
		}

		//何ターンでbに行けるかを計算しなくても
		//初めて0でない値が入っているところが答え
		for(int i = 1; i <= n; i++){
			if(dp[i][b] != 0){
				System.out.println(dp[i][b]);
				return;
			}
		}

	}

}
