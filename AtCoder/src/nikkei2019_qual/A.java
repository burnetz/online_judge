package nikkei2019_qual;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int max = Math.min(a, b);
		int min = Math.max((a + b) - n, 0);

		System.out.println(max + " " + min);
	}

}
