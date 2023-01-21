package arc113;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class B {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		//aの1の位のそれぞれについて位数を考えると
		//位数の最小公倍数は4なのでb^cもmod 4で考える。
		int tmpPow = (int)repeatablePow(b, c, 4);
		
		//ただし0乗は誤答になるので4乗にする
		if(tmpPow == 0) {
			tmpPow = 4;
		}
		System.out.println(repeatablePow(a, tmpPow, 10));
	}
	
	static long repeatablePow(int x, int n, int mod){
		if(n == 0){
			return 1;
		}
		long result = repeatablePow((int)((long)x*x%mod), n/2, mod);
		if(n % 2 == 1){
			result = result*x%mod;
		}
		return result;
	}
}

