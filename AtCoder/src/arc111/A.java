package arc111;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		int m = sc.nextInt();

		//10^nのかわりに10^n mod m^2で同じ答えを出せる（式変形で証明可能）
		System.out.println(repeatablePow(10, n, (long)m*m)/m % m );
	}
	
	static long repeatablePow(int x, long n, long mod){
		if(n == 0){
			return 1;
		}
		long result = repeatablePow((int)((long)x%mod*x%mod), n/2, mod);
		if(n % 2 == 1){
			result = result%mod*x%mod;
		}
		return result;
	}
}