package codefes2016qualc;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String str = sc.next();

		if(str.matches("[A-Z0-9]*C[A-Z0-9]*F[A-Z0-9]*")) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}

}
