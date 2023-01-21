package codefes2014quala;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String a = sc.next();
		int b = sc.nextInt() - 1;

		int n = a.length();

		b %= n;

		System.out.println(a.charAt(b));
	}

}
