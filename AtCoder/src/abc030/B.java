package abc030;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt()%12;
		int m = sc.nextInt();

		double theta1 = (60.0*n + m)/720*360;
		double theta2 = 1.0*m/60*360;

		double theta12 = Math.max(theta1, theta2) - Math.min(theta1, theta2);
		System.out.println(Math.min(theta12, 360-theta12));
	}
}