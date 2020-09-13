package abc178;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int s = sc.nextInt();

		if(s <= 2){
			System.out.println(0);
			return;
		}

		int mod = 1_000_000_007;
		long dp[] = new long[s + 1];
		for(int i = 3; i <= s; i++){
			//とりあえず1つだけの要素でも数列にはなるので1パターンはカウント
			dp[i] = 1;
			for(int j = 0; j <= i - 3; j++){
				dp[i] += dp[j];
				dp[i] %= mod;
			}
		}

		System.out.println(dp[s]);
	}
}

