package arc118;

import java.util.Scanner;

public class B {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();
		long n = sc.nextInt();
		long m = sc.nextInt();
		
		long a[] = new long[k];
		for(int i = 0; i < k; i++) {
			a[i] = sc.nextInt();
		}
		
		long left = -1;
		long right = m*n;
		
		//実現可能な最小の誤差を二分探索で求める。
		//なおdoubleではなくlongでやらないと誤差が出てしまう。
		while(right - left > 1) {
			long mid = (right + left)/2;
			
			//誤差midを満たすB[i]の最小の和と最大の和
			long minSum = 0;
			long maxSum = 0;
			for(int i = 0; i < k; i++) {
				long tmpBottom = bottom(a[i], n, m, mid);
				long tmpTop = top(a[i], n, m, mid);
				minSum += tmpBottom;
				maxSum += tmpTop;
			}
			
			if(minSum <= m && m <= maxSum) {
				right = mid;
			}
			else {
				left = mid;
			}
		}
		
		//まずは誤差rightを満たすことができる最低限の値をb[i]に代入する。
		long b[] = new long[k];
		long mCopy = m;
		for(int i = 0; i < k; i++) {
			b[i] = bottom(a[i], n, m, right);
			
			mCopy -= b[i];
		}
		
		//残った値は誤差rightを超えないように各b[i]にできるだけ多く加算する。
		for(int i = 0; i < k && mCopy > 0 ; i++) {
			long tmp = top(a[i], n, m, right) - bottom(a[i], n, m, right);
			tmp = Math.min(mCopy, tmp);
			b[i] += tmp;
			mCopy -= tmp;
		}
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < k ; i++) {
			sb.append(b[i] + " ");
		}
		System.out.println(sb);
	}
	
	static long bottom(long a, long n, long m, long eps) {
		return Math.max((m*a - eps + n - 1)/n , 0);
	}
	
	static long top(long a, long n, long m, long eps) {
		return (m*a + eps)/n;
	}
	
}