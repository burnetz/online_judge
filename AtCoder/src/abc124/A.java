package abc124;

import java.util.Arrays;
import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int a[] = new int[4];
		a[0] = sc.nextInt();
		a[1] = sc.nextInt();
		a[2] = a[0] - 1;
		a[3] = a[1] - 1;

		Arrays.sort(a);

		System.out.println(a[3] + a[2]);
	}

}
