package aising2019;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int h = sc.nextInt();
		int w = sc.nextInt();

		System.out.println((n - h + 1)*(n - w + 1));
	}

}
