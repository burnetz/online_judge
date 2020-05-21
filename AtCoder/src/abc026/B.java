package abc026;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		double result = 0;

		double r[] = new double[n];
		for(int i = 0; i < n; i++){
			r[i] = sc.nextInt();
		}

		Arrays.sort(r);

		for(int i = 0; i < n; i++){
			result += Math.pow(r[n - i - 1], 2)*Math.PI*(i % 2 == 0 ? 1 : -1);
		}

		System.out.println(result);
	}
}