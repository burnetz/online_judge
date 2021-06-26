package aclbeginner;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		long a = sc.nextLong();
		long b = sc.nextLong();
		long c = sc.nextLong();
		long d = sc.nextLong();

		System.out.println((b >= c && c >= a) || (d >= a && a >= c) ? "Yes" : "No");
	}

}
