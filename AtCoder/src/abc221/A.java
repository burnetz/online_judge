package abc221;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		long a = sc.nextInt();
		long b = sc.nextInt();
		
		System.out.println((long)Math.pow(32, a - b));
	}

}
