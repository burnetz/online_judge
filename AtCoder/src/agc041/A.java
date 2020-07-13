package agc041;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		long a = sc.nextLong();
		long b = sc.nextLong();

		if(a > b){
			long tmp = a;
			a = b;
			b = tmp;
		}

		//距離が偶数なら素直に歩み寄るのが最短
		if((b - a)%2 == 0){
			System.out.println(((b - a) + 1)/2);
		}
		//距離が奇数なら歩み寄っても合流できないので
		//どちらかが端っこで1回留まる必要がある
		else {
			if(a - 1 <= n - b){
				System.out.println((b + a)/2);
			}
			else {
				System.out.println((2*n - a - b + 1)/2);
			}
		}
	}

}
