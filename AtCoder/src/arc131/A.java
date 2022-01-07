package arc131;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		long a = sc.nextLong();
		long b = sc.nextLong();
		
		System.out.println(a + b * 1_000_000_000 / 2);
	}
}