package educationalDP;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int input[][] = new int[n][3];

		for(int i = 0; i < n; i++){
			for(int j = 0; j < 3; j++){
				input[i][j] = sc.nextInt();
			}
		}

		int dp[][] = new int[n][3];

		for(int i = 0; i < 3; i++){
			dp[0][i] = input[0][i];
		}

		for(int i = 1; i < n; i++){
			for(int j = 0; j < 3; j++){
				dp[i][j] = Math.max(dp[i - 1][(j + 1)%3], dp[i - 1][(j + 2)%3]) + input[i][j];
			}
		}

		System.out.println(Math.max(dp[n - 1][0], Math.max(dp[n - 1][1], dp[n - 1][2])));
	}
}
