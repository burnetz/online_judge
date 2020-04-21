package arc034;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		double max = 0;

		for(int i = 0; i < n; i++){
			double a = sc.nextInt();
			double b = sc.nextInt();
			double c = sc.nextInt();
			double d = sc.nextInt();
			double e = sc.nextInt();

			max = Math.max(max, a + b + c + d + e*11/90);
		}

		System.out.println(max);
	}
}
