package abc281;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		long t = sc.nextLong();
		
		long total = 0;
		
		long a[] = new long[n];
		long dp[] = new long[n + 1];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextLong();
			total += a[i];
			dp[i + 1] = dp[i] + a[i];
//			System.out.println(dp[i + 1]);
		}
		
		for(int i = 0; i < n; i++) {
			if(t%total >= dp[i] && t%total < dp[i + 1] ) {
				System.out.println((i + 1) + " " + (t%total - dp[i]));
				return;
			}
		}
		
		
	}
}

