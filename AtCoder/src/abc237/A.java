package abc237;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		
		if(n >= Integer.MIN_VALUE && n <= Integer.MAX_VALUE) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}
}
