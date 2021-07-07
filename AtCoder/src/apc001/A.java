package apc001;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		long x = sc.nextLong();
		long y = sc.nextLong();
		
		if(x % y == 0) {
			System.out.println("-1");
		}
		
		else {
			System.out.println(x);
		}
	}

}
