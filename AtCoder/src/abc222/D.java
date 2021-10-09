package abc222;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int a[] = new int[n];
		int b[] = new int[n];

		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
		}

		for(int i = 0; i < n; i++){
			b[i] = sc.nextInt();
		}

		int mod = 998244353;

		long dp[][] = new long[n][3001];
		for(int i = 0; i < n; i++){
			if(a[i] > b[i]){
				System.out.println(0);
				return;
			}
			for(int j = a[i] ; j <= 3000; j++){
				if(j != 0){
					dp[i][j] = dp[i][j - 1];
				}
				if(j <= b[i]){
					if(i == 0){
						dp[i][j] += 1;
					}
					else {
						dp[i][j] += dp[i - 1][j];
					}
				}

				dp[i][j] %= mod;

			}
		}

//		for(int i = 0; i < n; i++){
//			for(int j = 0; j < 10; j++){
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}

		System.out.println(dp[n - 1][b[n - 1]]);

	}

}

