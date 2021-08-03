package msolutions2020;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		//取る行動は全部買うか全部売るか何もしないかのみ
		long dp[] = new long[n + 1];
		dp[0] = 1000;
		dp[1] = 1000;
		for(int i = 2; i <= n; i++) {
			//「何もしない」のための初期化
			dp[i] = dp[i - 1];
			//全買いおよび全売りするタイミングを決める
			//全部でO(N^3)なので間に合う
			for(int j = 0; j < i; j++) {
				long amount = dp[j + 1]/a[j];
				long remain = dp[j + 1]%a[j];
				for(int k = j + 1; k < i; k++) {
					dp[i] = Math.max(dp[i], remain + amount*a[k]);
				}
			}
		}
		
		System.out.println(dp[n]);
	}

}
