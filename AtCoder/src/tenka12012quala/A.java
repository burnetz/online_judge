package tenka12012quala;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int a[] = new int[46];
		a[0] = a[1] = 1;
		for(int i = 2 ; i <= 45; i++) {
			a[i] = a[i - 2] + a[i - 1];
		}
		System.out.println(a[n]);
	}
}
