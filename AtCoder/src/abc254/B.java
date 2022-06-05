package abc254;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int dp[][] = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <= i; j++) {
				if(j == 0 || j == i) {
					dp[i][j] = 1;
				}
				else {
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
				}
				
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
	}
}