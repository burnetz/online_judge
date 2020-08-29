package abc177;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		double d = sc.nextInt();
		double t = sc.nextInt();
		double s = sc.nextInt();

		System.out.println(t*s >= d ? "Yes" : "No");
	}

}
