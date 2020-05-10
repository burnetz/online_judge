package abc167;

import java.util.Scanner;

public class E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();

		int mod = 998244353;

		fact[0] = 1;
		factInv[0] = 1;
		for(int i = 0; i < fact.length - 1; i++){
			fact[i+1] = fact[i]*(i+1) % mod; // n!(mod M)
	        factInv[i+1] = (int)(factInv[i]*repeatablePow(i+1, mod-2, mod) % mod);
		}

		if(m == 1){
			if(k == n - 1){
				System.out.println(1);
				return;
			}
			else {
				System.out.println(0);
				return;
			}
		}

		long result = 0;
		//セグメントがi個あった場合の色分けパターン総数
		long baseColorNum[] = new long[n + 1];

		//iをセグメントの個数とする。隣接するセグメントは必ず色が異なる
		//各セグメントのサイズは後で計算する
		for(int i = 1; i <= n; i++){
			if(i == 1){
				baseColorNum[i] = m;
			}
			else {
				baseColorNum[i] = baseColorNum[i - 1]*(m - 1);
				baseColorNum[i] %= mod;
			}

			int remain = n - i;

			//残りのブロックがk個以上だとどう割り振っても連続箇所がkより多くなる
			if(remain > k){
				continue;
			}

			//セグメントサイズはn-1箇所のどこにパーティションを入れるかと同じ考え方で計算できる
			long tmp = combination(n - 1, i - 1, mod)*baseColorNum[i];
			tmp %= mod;

			result += tmp;
			result %= mod;

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

	static long fact[] = new long[2000002];
	static long factInv[] = new long[2000002];

}
