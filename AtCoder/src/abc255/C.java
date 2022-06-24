package abc255;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		long x = sc.nextLong();
		long a = sc.nextLong();
		long d = sc.nextLong();
		long n = sc.nextLong();
		
		//簡単のため非減少数列にする。答えは変わらない。
		if(d < 0) {
			a *= -1;
			d *= -1;
			x *= -1;
		}
		
		//xがaより小さいときは増やすしかない
		if(x <= a) {
			System.out.println(a - x);
			return;
		}
		//この分岐に入るのは公差0かつx > aのとき
		if(d == 0) {
			System.out.println(x - a);
			return;
		}
		
		//ここに来る時点で増加数列であることが確定している。
		//xが何項目以降にあるかを計算しておく
		long floorN = (x - a)/d;
		
		//n項目よりもxが大きいなら減らすしかない。
		//なお今回の問題の成約ではn項目が非常に大きい可能性があるが
		//この分岐に入るパターンのときはオーバーフローの心配はない。
		if(floorN >= n - 1) {
			System.out.println(x - (a + (n - 1)*d));
			return;
		}
		
		//最後に残るパターン。
		//どこかとどこかの間にある。modが重要なので何項目なのかは関係ない。
		System.out.println(Math.min((x - a)%d, d - (x - a)%d));
		
	}
}
