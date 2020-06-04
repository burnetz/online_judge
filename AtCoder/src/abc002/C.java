package abc002;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		int x3 = sc.nextInt();
		int y3 = sc.nextInt();

		int v1x = x2 - x1;
		int v1y = y2 - y1;
		int v2x = x3 - x1;
		int v2y = y3 - y1;

		double lenV1 = Math.sqrt(v1x*v1x + v1y*v1y);
		double lenV2 = Math.sqrt(v2x*v2x + v2y*v2y);

		double cos = (v1x*v2x + v1y*v2y)/(lenV1*lenV2);
		double sin = Math.sqrt(1-cos*cos);

		System.out.println(0.5*sin*lenV1*lenV2);
	}
}