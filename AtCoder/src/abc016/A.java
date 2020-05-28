package abc016;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int d = sc.nextInt();

		System.out.println(m % d == 0 ? "YES" : "NO");
	}

}