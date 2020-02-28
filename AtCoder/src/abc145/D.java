package abc145;

import java.util.Scanner;

public class D {
	static long fact[] = new long[1000002];
	static long factInv[] = new long[1000002];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		final int MOD = 1_000_000_000 + 7;

		int x = sc.nextInt();
		int y = sc.nextInt();
		
		//ナイトの移動は少なくともこの条件を満たす必要がある
		if((2*x - y) % 3 != 0 || (2*y - x) % 3 != 0) {
			System.out.println(0);
			return;
		}
		
		fact[0] = 1;
		factInv[0] = 1;
		for(int i = 0; i < fact.length - 1; i++){
			fact[i+1] = fact[i]*(i+1) % MOD; // n!(mod M)
	        factInv[i+1] = (int)(factInv[i]*repeatablePow(i+1, MOD-2, MOD) % MOD);
		}
		
		//北北東と東北東
		int forward = (2*y - x)/3;
		int right = (2*x - y)/3;
		
		if(forward < 0 || right < 0) {
			System.out.println(0);
			return;
		}

		System.out.println(combination((x + y)/3, forward, MOD));
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
