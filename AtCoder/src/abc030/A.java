package abc030;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		double a = sc.nextInt();
		double b = sc.nextInt();
		double c = sc.nextInt();
		double d = sc.nextInt();

		System.out.println(b/a > d/c ? "TAKAHASHI" :
			b/a < d/c ? "AOKI" : "DRAW");
	}

}