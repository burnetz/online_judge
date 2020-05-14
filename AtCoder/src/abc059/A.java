package abc059;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		String a = sc.next().toUpperCase();
		String b = sc.next().toUpperCase();
		String c = sc.next().toUpperCase();


		System.out.println(a.charAt(0) +"" + b.charAt(0) + c.charAt(0));
	}
}