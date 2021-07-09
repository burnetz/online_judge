package arc120;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		long a[] = new long[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextLong();
		}
		
		long currentMax = a[0];
		long arrSum = a[0];
		System.out.println(a[0]*2);
		
		long sum = a[0];
		for(int i = 1; i < n; i++) {
			currentMax = Math.max(currentMax, a[i]);
			arrSum += a[i];
			sum += arrSum;
			
			System.out.println((i + 1)*currentMax + sum);
		}
		
	}
}