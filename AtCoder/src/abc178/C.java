package abc178;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		if(n == 1){
			System.out.println(0);
			return;
		}

		long all = 1;
		long no0 = 1;
		long no9 = 1;
		long no19 = 1;

		int mod = 1_000_000_007;
		long result = (long)n * (n - 1) % mod;

		for(int i = 2; i < n; i++){
			result *= 10;
			result %= mod;
		}

		for(int i = 0; i < n; i++){
			all *= 10; all %= mod;
			no0 *= 9; no0 %= mod;
			no9 *= 9; no9 %= mod;
			no19 *= 8; no19 %= mod;
		}

		result = (all + no19 + (mod - no9) + (mod - no0))%mod;

		System.out.println(result);
	}
}