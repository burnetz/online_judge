package codefes2014final;

import java.util.Arrays;
import java.util.Scanner;

public class E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int r[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			r[i] = sc.nextInt();
		}
		
		//dp[0][j] j文字目で上昇した場合の最長 dp[1][j] j文字目で下降した場合の最長
		int dp[][] = new int[2][n];
		
		Arrays.fill(dp[0], 1);
		Arrays.fill(dp[1], 1);
		
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < i ; j++) {
				if(r[j] < r[i]) {
					dp[0][i] = Math.max(dp[0][i], dp[1][j] + 1);
				}
				else if(r[j] > r[i]) {
					dp[1][i] = Math.max(dp[1][i], dp[0][j] + 1);
				}
			}
		}
		
		int result = 0;
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < n; j++) {
				result = Math.max(result, dp[i][j]);
			}
		}
		
		System.out.println(result >= 3 ? result : 0);
	}
}
