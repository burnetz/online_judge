package abc180;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		double dist1 = 0;
		double dist2 = 0;
		double dist3 = 0;
		for(int i = 0; i < n; i++){
			double input = sc.nextInt();

			dist1 += Math.abs(input);
			dist2 += input*input;
			dist3 = Math.max(dist3, Math.abs(input));
		}

		System.out.println(dist1);
		System.out.println(Math.sqrt(dist2));
		System.out.println(dist3);

	}
}
