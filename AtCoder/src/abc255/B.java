package abc255;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int a[] = new int[k];
		for(int i = 0; i < k; i++) {
			a[i] = sc.nextInt() - 1;
		}
		
		long x[] = new long[n];
		long y[] = new long[n];
		
		for(int i = 0; i < n; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		
		double minDist[] = new double[n];
		Arrays.fill(minDist, Double.MAX_VALUE);
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < k; j++) {
				double dx = x[i] - x[a[j]];
				double dy = y[i] - y[a[j]];
				
				double tmpDiff = Math.sqrt(dx*dx + dy*dy);
				
				minDist[i] = Math.min(minDist[i], tmpDiff);
			}
		}
		
		double result = 0;
		for(int i = 0; i < n; i++) {
			result = Math.max(result, minDist[i]);
		}
		
		System.out.println(result);
	}
}