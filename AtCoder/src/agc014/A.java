package agc014;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		long a[] = new long[3];

		for(int i = 0; i < 3; i++){
			a[i] = sc.nextInt();

			//最初から奇数なら既に終了条件
			if(a[i] % 2 == 1){
				System.out.println(0);
				return;
			}
		}

		//無限ループになるのは全てが同じ要素のとき
		if(a[2] == a[1] && a[1] == a[0]){
			System.out.println(-1);
			return;
		}

		int count = 0;

		//数式的には2のべき乗で割り続けるので案外早く結論が出る
		while(true){
			if(a[0] % 2 == 1 || a[1] % 2 == 1 || a[2] % 2 == 1){
				break;
			}
			count++;

			long s = a[0];
			long t = a[1];
			long u = a[2];

			a[0] = (t + u)/2;
			a[1] = (s + u)/2;
			a[2] = (s + t)/2;
		}

		System.out.println(count);

	}
}
