package abc094;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int x = sc.nextInt();

		System.out.println(x >= a && a + b >= x ? "YES" : "NO");
	}

}
