package diverta2019;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int r = sc.nextInt();
		int g = sc.nextInt();
		int b = sc.nextInt();
		int n = sc.nextInt();

		//dp[i][j] 色iまで選択してちょうどj個にする方法
		long dp[][] = new long[3][3001];

		for(int i = 0; i <= 3000; i += r){
			dp[0][i] = 1;
		}


		for(int i = 0; i <= 3000; i++){
			for(int j = i; j <= 3000; j += g){
				dp[1][j] += dp[0][i];
			}
		}

		for(int i = 0; i <= 3000; i++){
			for(int j = i; j <= 3000; j += b){
				dp[2][j] += dp[1][i];
			}
		}

		System.out.println(dp[2][n]);
	}

}
