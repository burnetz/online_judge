package abc238;

import java.math.BigInteger;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		long n = sc.nextLong();
		long result = 0;
		int mod = 998244353;
		for(int i = 0; i <= 18 && (long)Math.pow(10, i) <= n ; i++) {
			long low = (long)Math.pow(10, i);
			long high = (long)Math.min(n, (long)Math.pow(10, i + 1) - 1);
			long times = high - low + 1;
			
			long sum1 = 0;
			
			BigInteger bigSum = new BigInteger(Long.toString(low));
			bigSum = bigSum.add(new BigInteger(Long.toString(high)));
			bigSum = bigSum.multiply(new BigInteger(Long.toString(times)));
			bigSum = bigSum.divide(new BigInteger("2"));
			bigSum = bigSum.mod(new BigInteger(Integer.toString(mod)));
			sum1 = bigSum.longValue();

			times %= mod;
			
			long tmp = (long)((long)Math.pow(10, i) - 1)%mod*times%mod;
			
			result += sum1 + mod - tmp;
			result %= mod;
			
		}
		System.out.println(result);
	}
}