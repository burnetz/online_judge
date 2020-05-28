package abc015;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String t = sc.next();

		System.out.println(s.length() > t.length() ? s : t);
	}

}