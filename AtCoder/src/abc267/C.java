package abc267;

import java.util.Scanner;
import java.util.Vector;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		
		long a[] = new long[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextLong();
		}

		//事前に長さmの数列の単純な和を求めておけば
		//今回必要な積和も尺取り法で計算可能
		long sum[] = new long[n];
		
		for(int i = 0; i < m ; i++) {
			sum[0] += a[i];
		}
		
		for(int i = 1; i < n - m + 1; i++) {
			sum[i] = sum[i - 1] - a[i - 1] + a[i + m - 1];
		}
		
		long productSum[] = new long[n];
		
		for(int i = 0; i < m; i++) {
			productSum[0] += a[i]*(i + 1);
		}
		
		long result = productSum[0];
		for(int i = 1; i < n - m + 1; i++) {
			productSum[i] = productSum[i - 1] - sum[i - 1] + a[i + m - 1]*m;
			
			result = Math.max(result, productSum[i]);
		}
		
		System.out.println(result);
	}
	
}