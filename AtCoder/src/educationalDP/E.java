package educationalDP;

import java.util.Arrays;
import java.util.Scanner;

public class E {

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

		//dp[i][j]: i個まで見たときの、価値j以上にするための最低の重さ
		long dp[][] = new long[n + 1][100001];
		for(int i = 0; i <= n; i++){
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		dp[0][0] = 0;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < v[i]; j++){
				dp[i + 1][j] = Math.min(dp[i][j], w[i]);
			}
			for(int j = v[i]; j < dp[i].length; j++){
				dp[i + 1][j] = Math.min(dp[i][j], w[i] + dp[i][j - v[i]]);
			}
		}

		for(int i = 100000; i >= 0; i--){
			if(dp[n][i] <= W){
				System.out.println(i);
				return;
			}
		}

		System.out.println(0);
	}

}
