package abc210;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();

		System.out.println((int)(Math.min(n, a)*x + Math.max(0, n - a)*y));
	}

}
