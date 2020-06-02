package abc006;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int dp[] = new int[1_000_001];

		dp[3] = 1;

		for(int i = 4; i <= n; i++){
			dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3])%10007;
		}

		System.out.println(dp[n]);
	}
}