package arc107;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		long a = sc.nextInt();
		long b = sc.nextInt();
		long c = sc.nextInt();
		int mod = 998244353;

		long sumA = a*(a + 1)/2 % mod;
		long sumB = b*(b + 1)/2 % mod;
		long sumC = c*(c + 1)/2 % mod;

		System.out.println(sumA*sumB%mod*sumC%mod);
	}
}