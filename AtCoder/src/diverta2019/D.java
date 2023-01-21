package diverta2019;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();

		long sum = 0;
		
		//N = Md + d = (M + 1)dとなるためNの約数のみが候補となる。
		//割る数と余りの大小関係よりsqrt(N)までチェックすれば十分
		//（上記の条件を入れておかないと巨大な素数のときに内部のbreakだけでは弾けない）
		for(long i = 1; i < Math.sqrt(n); i++) {
			if(n%i == 0) {
				long a = n/i - 1;
				
				if(i >= a) {
					break;
				}
				sum += a;
			}
		}
		
		System.out.println(sum);
	}

}
