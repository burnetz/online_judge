package abc178;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		long a = sc.nextLong();
		long b = sc.nextLong();
		long c = sc.nextLong();
		long d = sc.nextLong();

		System.out.println(Math.max(a*c, Math.max(a*d, Math.max(b*c, b*d))));
	}
}
