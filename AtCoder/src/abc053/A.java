package abc053;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();

		System.out.println(x < 1200 ? "ABC": "ARC");
	}
}