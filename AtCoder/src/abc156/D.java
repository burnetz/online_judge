package abc156;

import java.util.Scanner;

public class D {
	static long fact[] = new long[300000];
	static long factInv[] = new long[300000];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();

		final int MOD = 1_000_000_000 + 7;

		//まずは2^n - 1
		long result = repeatablePow(2, n, MOD) - 1;


		fact[0] = 1;
		factInv[0] = 1;
		for(int i = 0; i < fact.length - 1; i++){
			fact[i+1] = fact[i]*(i+1) % MOD; // n!(mod M)
	        factInv[i+1] = (int)(factInv[i]*repeatablePow(i+1, MOD-2, MOD) % MOD);
		}

		result -= combination2(n, a, MOD);

		result -= combination2(n, b, MOD);

		//引き算をしたので答えが負になっていることがある
		while(result < 0){
			result += MOD;
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


	//今回はnが大きすぎるがa,b<=2*10^5なのでこちらを使う
	static long combination2(int n, int b, int mod){
		if(b == 1){
			return n;
		}

		long result = 1;

		for(int i = 1; i <= b ; i++){
			result *= (n - i + 1);
			result %= mod;
		}

		result *= factInv[b];

		return result % mod;
	}
//	static long combination(int a, int b, int mod){ //aCbをmod計算
//	    if(a == 0 && b == 0)return 1;
//	    if(a < b || a < 0)return 0;
//
//	    long tmp = factInv[a - b]* factInv[b] % mod;
//	    return tmp * fact[a] % mod;
//	}

}
