package abc011;

import java.util.Arrays;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int dp[] = new int[300 + 1];
		boolean ng[] = new boolean[300 + 1];
		for(int i = 0; i < 3; i++){
			ng[sc.nextInt()] = true;
		}

		Arrays.fill(dp, 1_000_000);
		dp[0] = 0;
		for(int i = 1; i <= n; i++){
			if(ng[i]){
				continue;
			}

			dp[i] = Math.min(dp[i], dp[i - 1] + 1);
			if(i >= 2){
				dp[i] = Math.min(dp[i], dp[i - 2] + 1);
			}
			if(i >= 3){
				dp[i] = Math.min(dp[i], dp[i - 3] + 1);
			}
		}

		if(dp[n] <= 100){
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}

	}
}