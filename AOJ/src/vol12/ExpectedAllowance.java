package vol12;

import java.util.Scanner;

public class ExpectedAllowance {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		while(true){
			int n = sc.nextInt();
			int m = sc.nextInt();
			int K = sc.nextInt();

			if(n == 0){
				break;
			}

			//dp[i][j] : i番目までのサイコロを使って合計がjになるパターン数
			int dp[][] = new int[n + 1][m*n + 1];

			for(int i = 1; i <= m; i++){
				dp[1][i] = 1;
			}

			//mが最大になるパターンとしてn=1を考えてもm=10^4,
			//あとはnが1大きくなるだけでmが大幅に小さくなるので
			//実はO(n^2 m^2)で十分間に合う
			for(int i = 2; i <= n; i++){
				for(int j = i - 1; j <= m*n; j++){
					for(int k = 1; k <= m; k++){
						if(j + k > m*n){
							break;
						}
						dp[i][j + k] += dp[i - 1][j];
					}
				}
			}

			double result = 0;
			for(int i = n; i <= m*n; i++){
				if(i <= K){
					result += dp[n][i];
				}
				else {
					result += dp[n][i] * (i - K);
				}
			}
			result /= Math.pow(m, n);

			System.out.println(result);
		}
	}

}
