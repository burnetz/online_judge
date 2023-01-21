package arc129;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		long l = sc.nextLong();
		long r = sc.nextLong();
		
		long pow[] = new long[64];
		pow[0] = 1;
		for(int i = 1; i <= 63; i++) {
			pow[i] = pow[i - 1] * 2;
		}
		
		long mask = 1;
		long result = 0;
		//最上位ビットがi桁目である数字を考える
		for(int i = 0; i <= 63; i++) {
			//nのiビット目が1であれば同じビット数のどの数でも条件を満たせる
			if((n & mask) != 0) {
				//ただしRとLは気にしなければならない。
				if(r < pow[i]) {
					break;
				}
				if(l >= pow[i + 1]) {
					mask <<= 1;
					continue;
				}
				result += pow[i];
				if(l > pow[i]) {
					result -= l - pow[i];
				}
				if(pow[i] <= r && r < pow[i + 1] - 1) {
					result -= pow[i + 1] - 1 - r;
					break;
				}
			}
			mask <<= 1;
		}
		
		System.out.println(result);
	}
}