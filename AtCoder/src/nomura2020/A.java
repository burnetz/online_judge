package nomura2020;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int h1 = sc.nextInt();
		int m1 = sc.nextInt();
		int h2 = sc.nextInt();
		int m2 = sc.nextInt();
		int k = sc.nextInt();

		System.out.println(h2*60 + m2 - h1*60 - m1 - k);
	}

}
