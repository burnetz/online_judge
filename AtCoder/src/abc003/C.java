package abc003;

import java.util.Arrays;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		int r[] = new int[n];
		for(int i = 0; i < n; i++){
			r[i] = sc.nextInt();
		}

		Arrays.sort(r);

		double rate = 0;

		for(int i = n - k; i < n; i++){
			rate = (rate + r[i])/2;
		}

		System.out.println(rate);
	}
}