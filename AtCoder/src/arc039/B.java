package arc039;

import java.util.Scanner;

public class B {
	static long fact[] = new long[102];
	static long factInv[] = new long[102];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		final int MOD = 1_000_000_000 + 7;
		fact[0] = 1;
		factInv[0] = 1;
		for(int i = 0; i < fact.length - 1; i++){
			fact[i+1] = fact[i]*(i+1) % MOD; // n!(mod M)
	        factInv[i+1] = (int)(factInv[i]*repeatablePow(i+1, MOD-2, MOD) % MOD);
		}

		long result = 0;
		//人数分以上ある場合、一番効率が良いのは極力同じ数ずつ配ること
		//実際に配られる個数は1人あたり高々2種類しかない。
		if(n <= k){
			int a = k%n;
			result = combination(n, a, MOD);
		}
		//人数分ない場合は別で計算が必要
		//キャンディに区別がないため重複順列の解き方ではなくdpでカウントする
		else {
			//dp[i][j] : i人目まで合計j個のキャンディを配るパターン数
			long dp[][] = new long[n + 1][k + 1];

			for(int i = 0; i < k + 1; i++){
				dp[1][i] = 1;
			}

			for(int i = 2; i <= n; i++){
				for(int j = 0; j <= k; j++){
					for(int l = 0; l <= j; l++){
						dp[i][j] += dp[i - 1][l];
						dp[i][j] %= MOD;
					}
				}
			}

			result = dp[n][k]%MOD;
		}

		System.out.println(result);


	}

	static long repeatablePow(int x, int n, int mod){
		if(n == 0){
			return 1;
		}
		long result = repeatablePow((int)((long)x*x%mod), n/2, mod);
		if(n % 2 == 1){
			result = result*x%mod;
		}
		return result;
	}

	static long combination(int a, int b, int mod){ //aCbをmod計算
	    if(a == 0 && b == 0)return 1;
	    if(a < b || a < 0)return 0;

	    long tmp = factInv[a - b]* factInv[b] % mod;
	    return tmp * fact[a] % mod;
	}
}