package arc012;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int va = sc.nextInt();
		int vb = sc.nextInt();
		double l = sc.nextInt();

		for(int i = 0; i < n; i++){
			double t = l/va;

			l = t*vb;
		}

		System.out.printf("%f\n", l);

	}
}
