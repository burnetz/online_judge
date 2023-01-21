package abc261;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		long x[] = new long[n];
		
		for(int i = 0; i < n; i++) {
			x[i] = sc.nextLong();
		}
		
		long bonus[] = new long[5001];
		
		for(int i = 0; i < m; i++) {
			bonus[sc.nextInt()] = sc.nextLong();
		}
		
		long dp[][] = new long[n + 1][5001];
		
		for(int i = 1; i <= n; i++) {
			long tmp = 0;
			//あるターンにポイントを獲得しない場合の最大値は1ターン前の最大値
			for(int j = 0; j <= 5000; j++) {
				tmp = Math.max(tmp, dp[i - 1][j]);
			}
			dp[i][0] = tmp;
			
			//このターンでポイントを獲得する場合の最大値を計算。
			//ただしjターンでカウンタがiより大きくなったら不正
			//（ルール上リセットはあっても余分にカウンタが回ることはない）なので回数を制御
			for(int j = 1; j <= i; j++) {
				dp[i][j] = dp[i - 1][j - 1] + x[i - 1];
				dp[i][j] += bonus[j];
			}
		}
		
		long result = 0;
		
		for(int i = 0; i <= 5000; i++) {
			result = Math.max(result, dp[n][i]);
		}
		
		System.out.println(result);
	}
}