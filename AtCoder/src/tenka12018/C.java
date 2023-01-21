package tenka12018;

import java.util.Arrays;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		Arrays.sort(a);
		
		//2回連続で増加・減少は効率が良くないので常に上下していると決めて良い。
		//内側の要素は2回加算されるか減算され、端の要素は1回だけ加算・減算される。
		//2回加算されるところになるべく大きい要素を、
		//2回減算されるところになるべく小さい要素を配置すればよい。
		
		// \/\/\などのパターン。
		if(n % 2 == 0) {
			long bottom = 0;
			long top = 0;
			
			for(int i = 0; i < (n - 2)/2 ; i++) {
				bottom += a[i];
				top += a[n - i - 1];
			}
			
			System.out.println(top * 2 - bottom * 2 + a[(n - 2)/2 + 1] - a[(n - 2)/2]);
		}
		// Nが奇数の場合、例えば同じN=5でも \/\/と/\/\がありえる。
		// どちらが大きくなるかわからないので両方計算する必要がある。
		else {
			long bottom = 0;
			long top = 0;
			
			for(int i = 0; i < (n - 2)/2 ; i++) {
				bottom += a[i];
				top += a[n - i - 1];
			}

			long result1 = top*2 - (bottom + a[(n - 2)/2])*2 + a[n/2] + a[(n + 1)/2];
			long result2 = (top + a[n - (n - 2)/2 - 1])*2 - bottom*2 - a[(n - 2)/2] - a[(n - 1)/2];
			System.out.println(Math.max(result1, result2));
		}
	}

}
