package abc151;

import java.util.Arrays;
import java.util.Scanner;

public class E {
	static long fact[] = new long[1000002];
	static long factInv[] = new long[1000002];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		final int MOD = 1_000_000_000 + 7;

		fact[0] = 1;
		factInv[0] = 1;
		for(int i = 0; i < fact.length - 1; i++){
			fact[i+1] = fact[i]*(i+1) % MOD; // n!(mod M)
	        factInv[i+1] = (int)(factInv[i]*repeatablePow(i+1, MOD-2, MOD) % MOD);
		}

		int n = sc.nextInt();
		int k = sc.nextInt();

		int a[] = new int[n];
		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
		}

		Arrays.sort(a);

		//Kが1ならmaxとminは必ず同じ
		if(k == 1){
			System.out.println(0);
			return;
		}

		long sumArray[] = new long[n];
		sumArray[0] = a[0];
		for(int i = 1; i < n; i++){
			sumArray[i] = sumArray[i - 1] + a[i];
		}

		//最大値と最小値のインデックスを決めれば、その間からどのようにK-2個選んでも最大最小の差は同じはず
		//最大値と最小値の組み合わせを全部調べようとすると普通にやるとO(N^2)になってしまうので
		//事前に部分和を求めて効率化する。
		long result = 0;
		for(int i = k - 2; i <= n - 2; i++){
			//間にmod計算を挟まないとlongでも普通にオーバーフローする
			result += (sumArray[n - 1] - sumArray[i] - sumArray[n - i - 2])%MOD*combination(i, k - 2, MOD);
			result %= MOD;
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
