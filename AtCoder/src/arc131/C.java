package arc131;

import java.util.Scanner;

public class C {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		int a[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		//極端な例として残り1枚の場合は必ず勝てる。残り3枚も必ず勝つ。
		//もともと奇数枚ならそれと似たような状況に持ち込むことができる。
		if(n % 2 == 1) {
			System.out.println("Win");
			return;
		}
		int xorAll = 0;
		for(int i = 0; i < n; i++) {
			xorAll ^= a[i];
		}
		
		//このゲームは奇数枚側が圧倒的に有利なので
		//偶数スタートの場合は初手で0にできなければ負ける。
		for(int i = 0; i < n; i++) {
			if((xorAll ^ a[i]) == 0) {
				System.out.println("Win");
				return;
			}
		}
		
		System.out.println("Lose");
	}
}