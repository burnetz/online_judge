package abc185;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int l = sc.nextInt();
		long dp[][] = new long[l + 1][13];
		dp[0][1] = 1;
		for(int i = 1; i <= l - 1; i++) {
			for(int j = 1; j <= 12; j++) {
				dp[i][j] = dp[i - 1][j];
				if(j >= 2) {
					dp[i][j] += dp[i - 1][j - 1];
				}
			}
		}
		
		System.out.println(dp[l - 1][12]);
	}

}
