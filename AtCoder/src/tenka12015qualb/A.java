package tenka12015qualb;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 20;
		int a[] = new int[n];
		a[0] = 100;
		a[1] = 100;
		a[2] = 200;
		for(int i = 3; i < n; i++) {
			a[i] = a[i - 1] + a[i - 2] + a[i - 3];
		}
		
		System.out.println(a[n - 1]);
	}

}
