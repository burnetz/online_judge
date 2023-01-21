package abc246;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		long n = sc.nextLong();

		//a = 10^6でf(a,0)>=10^18となり、a,bについて単調増加なので
		//aの上限は10^6で十分
		long a = 1000000;
		
		long result = Long.MAX_VALUE;
		
		//各aについて条件を満たす最小のbを2分探索で求める
		for(long i = a; i >= 0 && func(i, i) >= n; i--) {
			long l = -1, r = i ;
			long mid = (l + r)/2;
			while(l + 1< r) {
				mid = (l + r)/2;
				
				long tmp = func(i, mid);
				if(tmp >= n) {
					r = mid;
				}
				else {
					l = mid;
				}
			}
			result = Math.min(result, func(i, r));
		}
		
		System.out.println(result);
	}
	
	static long func(long a, long b) {
		return a*a*a + a*a*b + a*b*b + b*b*b;
	}
}

