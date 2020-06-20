package abc015;

import java.util.Scanner;

public class D {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int w = sc.nextInt();
		int n = sc.nextInt();
		int k = sc.nextInt();

		int a[] = new int[n + 1];
		int b[] = new int[n + 1];

		for(int i = 1; i <= n ; i++){
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		//dp[i][j][k] : 幅iでj番目までの写真のうちk枚使ったときの最大値
		int dp[][][] = new int[w + 1][n + 1][k + 1];

		for(int i = 1; i <= w; i++){
			for(int j = 1; j <= n; j++){
				for(int l = 1; l <= k; l++){
					//j枚目を使うか使わないかでより値が大きい方を選ぶ
					if(i >= a[j]){
						dp[i][j][l] = Math.max(dp[i - a[j]][j - 1][l - 1] + b[j], dp[i][j - 1][l]);
					}
					else {
						dp[i][j][l] = dp[i][j - 1][l];
					}
				}
			}
		}

		System.out.println(dp[w][n][k]);
	}

}