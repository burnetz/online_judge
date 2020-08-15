package educationalDP;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int W = sc.nextInt();

		int w[] = new int[n];
		int v[] = new int[n];

		for(int i = 0; i < n; i++){
			w[i] = sc.nextInt();
			v[i] = sc.nextInt();
		}

		long dp[][] = new long[n + 1][W + 1];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < w[i]; j++){
				dp[i + 1][j] = dp[i][j];
			}
			for(int j = w[i]; j <= W; j++){
				dp[i + 1][j] = Math.max(dp[i][j], v[i] + dp[i][j - w[i]]);
			}
		}

		System.out.println(dp[n][W]);
	}

}
