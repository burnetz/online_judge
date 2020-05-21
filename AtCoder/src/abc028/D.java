package abc028;

import java.util.Scanner;

public class D {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		//分母を3乗するのでlongじゃないとオーバーフロー
		long n = sc.nextInt();
		int k = sc.nextInt();


		System.out.println(1.0/n * (k - 1)/n * (n - k)/n * 6 + 1.0/(n*n) * (n - k)/n * 3 + 1.0/(n*n) * (k - 1)/n * 3 + 1.0/(n*n*n));
	}

}