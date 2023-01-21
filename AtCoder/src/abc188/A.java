package abc188;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int y = sc.nextInt();
		System.out.println(Math.abs(x - y) <= 2 ? "Yes" : "No");
	}

}
