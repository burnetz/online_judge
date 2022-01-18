package abc235;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		int a = str.charAt(0) - '0';
		int b = str.charAt(1) - '0';
		int c = str.charAt(2) - '0';
		
		System.out.println((a + b + c)*111);
	}
}
