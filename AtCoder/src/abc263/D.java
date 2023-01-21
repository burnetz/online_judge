package abc263;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int l = sc.nextInt();
		int r = sc.nextInt();
		
		int a[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		//左から足したときのi番目までの最小値
		long sum1[] = new long[n];
		//右から足したときのi番目までの最小値
		long sum2[] = new long[n + 1];
		
		sum1[0] = Math.min(l, a[0]);
		
		//動的計画法で考える。
		//i番目までの最小値は前の結果にそのままa[i]を足すか、そこまでの要素を全てlに変えるか
		for(int i = 1; i < n; i++) {
			sum1[i] = Math.min(sum1[i - 1] + a[i], (long)(i + 1)*l);
		}
		
		sum2[n - 1] = Math.min(r, a[n - 1]);
		
		for(int i = n - 2; i >= 0; i--) {
			sum2[i] = Math.min(sum2[i + 1] + a[i], (long)(n - i) * r);
		}
		
		long result = (long)r*n;
		
		for(int i = 0; i < n; i++) {
			result = Math.min(result, sum1[i] + sum2[i + 1]);
		}
		
		System.out.println(result);
	}
}