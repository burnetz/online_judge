package educationalDP;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int input[] = new int[n];
		for(int i = 0; i < n; i++){
			input[i] = sc.nextInt();
		}

		int dp[] = new int[n];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for(int i = 1; i < n; i++){
			for(int j = 1; j <= k && i - j >= 0; j++){
				dp[i] = Math.min(dp[i], dp[i - j] + Math.abs(input[i] - input[i - j]));
			}
		}

		System.out.println(dp[n - 1]);
	}

}

