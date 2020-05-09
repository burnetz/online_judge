package abc099;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int powers2[] = new int[11];
		int powers3[] = new int[11];

		powers2[0] = 1;
		powers3[0] = 1;
		for(int i = 1; i <= 10; i++){
			powers2[i] = 2*powers2[i - 1];
			powers3[i] = 3*powers3[i - 1];

		}

		int dp[] = new int[n + 1];

		dp[1] = 1;

		for(int i = 2; i <= n; i++){
			int tmp;
			//タイプa
			tmp = dp[i - 1] + 1;

			//タイプb
			for(int j = 0; powers2[j]*powers3[j] <= i ; j++){
				tmp = Math.min(tmp, dp[i - powers2[j]*powers3[j]] + 1);
			}

			//タイプc
			for(int j = 0; powers3[j]*powers3[j] <= i ; j++){
				tmp = Math.min(tmp, dp[i - powers3[j]*powers3[j]] + 1);
			}

			dp[i] = tmp;
		}

		System.out.println(dp[n]);
	}
}

