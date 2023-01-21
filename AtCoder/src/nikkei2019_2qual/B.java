package nikkei2019_2qual;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int a[] = new int[n];
		int mod = 998244353;
		int count[] = new int[100000 + 1];
		int maxDist = 0;
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			count[a[i]]++;
			maxDist = Math.max(maxDist, a[i]);
		}
		
		//頂点1から見て距離が0である頂点はただ1つ頂点1のみである必要がある。
		//他の頂点は等距離の個数だけ記録すれば良いが頂点1だけは特別にチェックする必要がある。
		if(a[0] != 0) {
			System.out.println(0);
			return;
		}
		
		if(n == 1) {
			System.out.println(1);
			return;
		}
		
		//距離0が複数あってはいけない
		if(count[0] > 1) {
			System.out.println(0);
			return;
		}
		
		long result = 1;
		//距離iの点は距離i-1のどの点に接続しても良い
		//もし距離に歯抜けの箇所があれば答えは0になる。
		for(int i = 1; i <= maxDist; i++) {
			result *= repeatablePow(count[i - 1], count[i], mod);
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
}
