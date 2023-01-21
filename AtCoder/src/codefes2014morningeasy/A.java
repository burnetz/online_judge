package codefes2014morningeasy;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		long a[] = new long[n];

		for(int i = 0; i < n; i++){
			a[i] = sc.nextLong();
		}

		long sum1 = 0;
		long sum2 = 0;

		for(int i = 1; i < n; i++){
			sum1 += a[i - 1];
			sum2 += a[i];
		}

		System.out.println((sum2 - sum1)/(double)(n - 1));
	}
}
