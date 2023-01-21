package abc182;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		long a[] = new long[n];
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextLong();
		}
		//一連の動きをした場合の各ターンの変位
		long dp[] = new long[n];
		dp[0] = a[0];
		//各ターンにおける正方向最大の変位
		long maxArray[] = new long[n];
		//初手マイナスもあり得るので必要な初期化
		maxArray[0] = Math.max(0, a[0]);
		for(int i = 1; i < n; i++) {
			dp[i] = dp[i - 1] + a[i];
			//max()内で比較しているのはa[i]を含むかどうかの違い
			maxArray[i] = Math.max(maxArray[i - 1], dp[i]);
		}
		
		long result = Long.MIN_VALUE;
		long pos = 0;
		for(int i = 0; i < n; i++) {
			result = Math.max(pos + maxArray[i], result);
			pos += dp[i];
		}
		
		System.out.println(result);
		
	}

}
