package abc189;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		String op[] = new String[n];
		
		for(int i = 0; i < n; i++) {
			op[i] = sc.next();
		}
		
		//dp[i][0] : y_i = trueとなるパターン数
		//dp[i][1] : y_i = falseとなるパターン数
		long dp[][] = new long[n + 1][2];
		dp[0][0] = dp[0][1] = 1;
		
		for(int i = 1; i <= n; i++) {
			switch (op[i - 1]) {
			case "AND":
				dp[i][0] = dp[i - 1][0];
				//y[i - 1]がFならx[i]にかかわらずy[i]がFになるため2倍
				dp[i][1] = dp[i - 1][0] + dp[i - 1][1]*2;
				break;

			default:
				dp[i][0] = dp[i - 1][0]*2 + dp[i - 1][1];
				dp[i][1] = dp[i - 1][1];
				break;
			}
		}
		
		System.out.println(dp[n][0]);
	}

}
