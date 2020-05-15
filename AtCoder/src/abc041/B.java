package abc041;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long a = sc.nextLong();
		long b = sc.nextLong();
		long c = sc.nextLong();
		int mod = 1_000_000_007;

		System.out.println(a*b%mod*c%mod);
	}
}