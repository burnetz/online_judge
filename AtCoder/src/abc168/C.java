package abc168;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int h = sc.nextInt();
		int m = sc.nextInt();

		double theta1 = 2*Math.PI*(h*60 + m)/720;
		double theta2 = 2*Math.PI*m/60;

		double x1 = a*Math.cos(theta1);
		double y1 = a*Math.sin(theta1);
		double x2 = b*Math.cos(theta2);
		double y2 = b*Math.sin(theta2);

		System.out.println(Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)));
	}

}