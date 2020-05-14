package abc056;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();

		System.out.println(a.equals(b) ? "H" : "D");
	}
}