package agc030;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		//順番を守る必要はない。まずは解毒剤入りの美味しいクッキーを全部食べる
		//美味しい毒入りクッキーの上限数は両解毒剤入りクッキーの枚数で決まる。
		//1足してあるのは最後に食べる毒入りクッキーの解毒が不要だから。
		int result = b + Math.min(a + b + 1, c);

		System.out.println(result);
	}
}
