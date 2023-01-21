package keyence2020;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int w = sc.nextInt();
		int n = sc.nextInt();

		System.out.println((int)Math.min(Math.ceil((double)n/h), Math.ceil((double)n/w)));
	}

}
