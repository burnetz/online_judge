package arc142;

import java.util.Arrays;
import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		long a[] = new long[3];
		
		for(int i = 0; i < 3; i++) {
			a[i] = sc.nextLong();
		}
		
		Arrays.sort(a);
		
		if(a[2] > a[0] + a[1]) {
			System.out.println(-1);
			return;
		}
		else {
			System.out.println(a[2]);
		}
	}

}