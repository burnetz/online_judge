package jsc2021;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int p = sc.nextInt();
		int mod = 1_000_000_007;

		//最初の数字だけ(p - 1)種類選べる
		//2個目以降は足してpの倍数になるもの（必ず1つある）を除く(p - 2)種類から選べる
		System.out.println(repeatablePow(p - 2, n - 1, mod)*(p - 1)%mod);

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
