package educationalDP;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int input[] = new int[n];
		for(int i = 0; i < n; i++){
			input[i] = sc.nextInt();
		}

		int dp[] = new int[n];
		dp[1] = Math.abs(input[1] - input[0]);
		for(int i = 2; i < n; i++){
			dp[i] = Math.min(dp[i - 1] + Math.abs(input[i] - input[i - 1]), dp[i - 2] + Math.abs(input[i] - input[i - 2]));
		}

		System.out.println(dp[n - 1]);
	}

}
