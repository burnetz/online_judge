package arc036;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		int a[] = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();

			if(i >= 2 && a[i] + a[i - 1] + a[i - 2] < k){
				System.out.println(i + 1);
				return;
			}
		}

		System.out.println(-1);
	}
}