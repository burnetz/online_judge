package abc266;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		long snuke[][] = new long[100001][5];
		
		for(int i = 0; i < n; i++) {
			int t = sc.nextInt();
			int x = sc.nextInt();
			long point = sc.nextLong();
			
			snuke[t][x] = point;
		}
		
		//dp[i][j] : 時刻iに座標jにいる場合の最高得点
		long dp[][] = new long[100001][5]; 
		for(int i = 0; i < snuke.length; i++) {
			Arrays.fill(dp[i], Long.MIN_VALUE);
		}
		dp[0][0] = 0;
		for(int i = 1; i < dp.length; i++) {
			//1マス移動するかとどまるかしか選べないことに注意する
			for(int j = 0; j < 5; j++) {
				if(j >= 1) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + snuke[i][j]);
				}
				if(j <= 3) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j + 1] + snuke[i][j]);
				}
				dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + snuke[i][j]);
			}
		}
		
		long result = 0;
		for(int i = 0; i < 5; i++) {
			result = Math.max(result, dp[dp.length - 1][i]);
		}
		
		System.out.println(result);
	}
}