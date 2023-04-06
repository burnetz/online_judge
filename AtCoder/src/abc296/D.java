package abc296;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		long m = sc.nextLong();
		
		long minDiff = Long.MAX_VALUE;
		long result = -1;
		
		//iをaとみなし、ab >= mとなる最小のbを二分探索で探す。
		for(int i = 1; i <= n ; i++) {
			long left = 0;
			long right = 1_000_000_000_000_0L;
			
			long mid = Math.min( (left + right)/2, n);
			
			while(left + 1 < right) {
				//前半の条件はオーバーフロー対策
				if(mid >= Long.MAX_VALUE / i ||  mid * i >= m) { //ok
					right = mid;
				}
				else { //ng
					left = mid;
				}
				mid = (right + left)/2;
			}
			
			//a > bとなっているパターン。この先に適切な解があるとしても既知のはずなので終了。
			if(right < i) {
				break;
			}
			//後半の条件はオーバーフロー対策
			if(right > n || right >= Long.MAX_VALUE / i) {
				continue;
			}
			long tmpResult = right * i;
			
			if(tmpResult - m < minDiff) {
				minDiff = tmpResult - m;
				result = tmpResult;
			}
		}
		
		System.out.println(result);
	}

}
