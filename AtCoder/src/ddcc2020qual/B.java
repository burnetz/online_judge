package ddcc2020qual;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		long a[] = new long[n];
		
		long sum = 0;
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextLong();
			sum += a[i];
		}
		
		long left = 0;
		long result = Long.MAX_VALUE;
		for(int i = 0; i < n - 1; i++) {
			left += a[i];
			long right = sum - left;
			
			result = Math.min(result, Math.abs(left - right));
		}
		
		System.out.println(result);
	}

}
