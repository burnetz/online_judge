package agc004;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		long a = sc.nextLong();
		long b = sc.nextLong();
		long c = sc.nextLong();

		long result = Long.MAX_VALUE;

		result = Math.min(result, Math.abs(a/2 - a + a/2)*b*c);
		result = Math.min(result, Math.abs(b/2 - b + b/2)*a*c);
		result = Math.min(result, Math.abs(c/2 - c + c/2)*b*a);

		System.out.println(result);
	}

}
