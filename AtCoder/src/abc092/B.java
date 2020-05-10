package abc092;

import java.io.IOException;
import java.util.Scanner;

public class B {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int d = sc.nextInt();
		int x = sc.nextInt();

		int a[] = new int[n];

		int sum = 0;
		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();

			sum += 1 + (d - 1)/a[i];
		}

		System.out.println(x + sum);

	}
}
