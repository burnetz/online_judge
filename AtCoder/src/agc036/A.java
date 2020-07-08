package agc036;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//うち1点を原点に固定すれば外積の公式でsを求められる。
		//更に、x2=10^9, y2=1に固定すれば10^9y3 - x3 = sとなり
		//どのようなsでもx3,y3を適切に組み合わせれば求められることがわかる
		long s = sc.nextLong();
		int mod = 1_000_000_000;
		long x = (mod - s%mod)%mod;
		long y = (s + x)/mod;

		System.out.println("0 0 1000000000 1 " + x + " " + y);
	}

}
