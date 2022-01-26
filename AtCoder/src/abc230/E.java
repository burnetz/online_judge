package abc230;

import java.util.Scanner;

public class E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		
		long result = 0;
		//[N/i]は単調減少なのでどこからどこまで同じ値かが分かればある程度まとめて計算できる。
		for(long i = n; i >= 1; ) {
			//[N/j]=iとなる最小のjと最大のjを求める
			long l = n / (i + 1) + 1;
			long r = n / i;
			
			result += (r - l + 1)*i;
			
			//iを1個ずつ更新すると間に合わない。
			//rの1個右は確実に値が変わっているのでそれを利用する。
			i = n/(r + 1);
		}
		
		System.out.println(result);
	}

}
