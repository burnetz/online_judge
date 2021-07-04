package zone2021;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int d = sc.nextInt();
		int h = sc.nextInt();

		double maxHeight = 0;
		for(int i = 0; i < n; i++){
			int tmpD = sc.nextInt();
			int tmpH = sc.nextInt();

			double a = (double)(h - tmpH)/(d - tmpD);
			double b = tmpH - a*tmpD;

			maxHeight = Math.max(maxHeight, b);
		}

		System.out.println(maxHeight);
	}

}
