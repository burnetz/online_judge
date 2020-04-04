package abc161;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		long k = sc.nextLong();

		n = n % k;

		System.out.println(Math.min(k - n, n));
	}

}
