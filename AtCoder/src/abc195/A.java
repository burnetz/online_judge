package abc195;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int m = sc.nextInt();
		int h = sc.nextInt();

		System.out.println(h % m == 0 ? "Yes" : "No");
	}

}
