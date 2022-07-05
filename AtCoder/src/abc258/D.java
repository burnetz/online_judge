package abc258;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int x = sc.nextInt();
		
		long a[] = new long[n];
		long b[] = new long[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextLong();
			b[i] = sc.nextLong();
		}
		
		long minGame = Integer.MAX_VALUE;
		long result = Long.MAX_VALUE;
		long tmpSum = 0;
		//どこまで遊んでどこのステージを繰り返すのが最適なのかは一通り調べないとわからない。
		for(int i = 0; i < Math.min(x, n); i++) {
			tmpSum += a[i] + b[i];
			minGame = Math.min(b[i], minGame);
			
			//ここまでで最短のステージをひたすら繰り返す場合と比較する。
			result = Math.min(result, tmpSum + minGame*(x - i - 1));
		}
		
		System.out.println(result);
	}
}