package abc037;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		int a[] = new int[n];

		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
		}

		long total = 0;
		for(int i = 0; i < k; i++){
			total += a[i];
		}

		long part = total;
		for(int i = k; i < n; i++){
			part = part - a[i - k] + a[i];
			total += part;
		}

		System.out.println(total);
	}
}

