package abc191;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int v = sc.nextInt();
		int t = sc.nextInt();
		int s = sc.nextInt();
		int d = sc.nextInt();

		int x1 = v*t;
		int x2 = v*s;

		System.out.println(d < x1 || d > x2 ? "Yes" : "No");

	}

}
