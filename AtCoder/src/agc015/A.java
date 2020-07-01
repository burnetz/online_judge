package agc015;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		long a = sc.nextLong();
		long b = sc.nextLong();

		if(a > b || (n == 1 && a != b)){
			System.out.println(0);
			return;
		}
		long minSum = a*(n - 1) + b;
		long maxSum = a + b*(n - 1);

		System.out.println(maxSum - minSum + 1);
	}
}
