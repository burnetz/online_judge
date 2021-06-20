package sumitb2019;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int m1 = sc.nextInt();
		int d1 = sc.nextInt();
		int m2 = sc.nextInt();
		int d2 = sc.nextInt();

		System.out.println(m1%12 == m2 - 1 ? 1 : 0);
	}

}
