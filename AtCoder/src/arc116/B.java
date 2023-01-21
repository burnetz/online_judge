package arc116;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class B {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		long a[] = new long[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextLong();
		}
		//全ての部分列を試すので、ソートしても和は変わらない
		Arrays.parallelSort(a);
		int mod = 998244353;
		long result = 0;
		
		//例えばA_iの係数はA_1+A_2+2A_3+2^2A_4+...+2^(i-2)A_i
		//これをdpで作る
		long dp[] = new long[n];
		dp[n - 1] = a[n - 1];
		if(n >= 2) {
			dp[n - 2] = a[n - 2];
		}
		for(int i = n - 2; i >= 0; i--) {
			dp[i] = ((dp[i + 1] + mod - a[i + 1])*2 + a[i] + a[i + 1])%mod;
		}
		
		for(int i = 0; i < n; i++) {
			result += a[i]*dp[i]%mod;
			result %= mod;
		}
		
		System.out.println(result);
	}
}