package abc190;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		
		//項が1つのみの自明な解
		long result = 1;
		
		//等差数列の和の公式を変形すると
		//a = (2*S_n - n^2 + n)/(2n)となる。これが自然数になるなら解として適当
		for(long i = 2; i <= n; i++) {
			long tmp = 2*n - i*i + i;
			
			if(tmp <= 0) {
				break;
			}
			
			if(tmp % (2*i) == 0) {
				result++;
			}
		}
		
		//上でカウントした解に加えて
		//-2,-1,0,1,2のような左右対称かつ合計0の数列を付与したものも答え
		System.out.println(result*2);
	}

}
