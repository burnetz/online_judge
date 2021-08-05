package abc205;

import java.util.Arrays;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int q = sc.nextInt();
		
		long a[] = new long[n + 2];
		a[0] = 0;
		a[n + 1] = Long.MAX_VALUE;
		long sum[] = new long[n + 2];
		
		for(int i = 1; i <= n; i++) {
			a[i] = sc.nextLong();
		}
		Arrays.parallelSort(a);

		//配列の要素間に入れられる整数の数の和を記録する
		for(int i = 1; i <= n + 1; i++) {
			sum[i] = sum[i - 1] + (a[i] - a[i - 1] - 1);
		}
		
		for(int i = 0; i < q; i++) {
			long k = sc.nextLong();
			
			int l = 0;
			int r = n + 1;
			//ちょうどよいところを二部探索で探す
			//端を0と巨大な数にしたので必ず見つかる
			while(r - l > 1) {
				int mid = (l + r)/2;
				
				if(sum[mid] >= k) {
					r = mid;
				}
				else {
					l = mid;
				}
			}
			
			System.out.println(a[l] + (k - sum[l]));
		}
	}

}
