package abc037;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int q = sc.nextInt();
		int a[] = new int[n];

		for(int i = 0; i < q; i++){
			int l = sc.nextInt() - 1;
			int r = sc.nextInt() - 1;
			int t = sc.nextInt();

			for(int j = l; j <= r; j++){
				a[j] = t;
			}
		}

		for(int i = 0; i < n; i++){
			System.out.println(a[i]);
		}
	}
}