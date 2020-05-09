package abc097;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();

		int dab = Math.abs(a - b);
		int dbc = Math.abs(b - c);
		int dca = Math.abs(c - a);

		System.out.println((dca <= d) || (dab <= d && dbc <= d) ? "Yes" : "No");
	}

}
