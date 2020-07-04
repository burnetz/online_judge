package agc031;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int input[] = new int[n + 2];
		final int COLOR_MAX = 2_000_01;

		input[0] = COLOR_MAX;
		for(int i = 1; i <= n; i++){
			input[i] = sc.nextInt();
		}
		input[n + 1] = COLOR_MAX;

		//i番目までで作ることができるパターン数
		long dp[] = new long[n + 1];
		dp[0] = 1;
		int mod = 1_000_000_007;
		long sumOfEachColor[] = new long[COLOR_MAX + 1];
		sumOfEachColor[input[1]] = 1;
		//考え方としてはi番目とi-1番目の色が異なるならi番目と同じ色のjについて
		//dp[j]を合計したものがdp[i]となる。
		//ただO(N^2)では間に合わないので、dp[i]が単調増加であることに注目して高速化を図る
		for(int i = 1; i <= n; i++){
			dp[i] = sumOfEachColor[input[i]];

			//ある色についてdp[i]の合計を保存しておけば内側はループ不要
			if(input[i] != input[i + 1]){
				sumOfEachColor[input[i + 1]] += dp[i];
				sumOfEachColor[input[i + 1]] %= mod;
			}

		}

		System.out.println(dp[n]);
	}
}
