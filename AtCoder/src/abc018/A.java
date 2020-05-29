package abc018;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		System.out.println(a > b && a > c ? 1 :
			a < b && a < c ? 3 : 2);
		System.out.println(b > a && b > c ? 1 :
			b < a && b < c ? 3 : 2);
		System.out.println(c > b && c > a ? 1 :
			c < b && c < a ? 3 : 2);
	}

}