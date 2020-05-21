package abc026;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		System.out.println(a/2*(a - a/2));
	}

}