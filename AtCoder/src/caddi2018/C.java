package caddi2018;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		long p = sc.nextLong();
		
		boolean isPrime = true;
		for(int i = 2; i <= Math.sqrt(p); i++) {
			if(p%i == 0) {
				isPrime = false;
				break;
			}
		}
		
		if(isPrime && p == 1) {
			System.out.println(1);
			return;
		}
		
		//nが1の場合は明らかに答えはp
		//ここで処理しておかないとp次第ではループでTLEになる
		if(n == 1) {
			System.out.println(p);
			return;
		}
		
		//約数を均等に配分するのが最適なので
		//p^nがいくつ含まれているかを調べる。
		int div = 2;
		long result = 1;
		while(p > 1) {
			//nと素数の組み合わせによってはオーバーフローするのでここで桁数チェック
			if(n*Math.log10(div) >= 14) {
				break;
			}
			//ほぼ素因数分解と同じ
			while(p % Math.pow(div, n) == 0) {
				p /= Math.pow(div, n);
				result *= div;
			}
			
			div++;
		}
		
		System.out.println(result);
	}

}
