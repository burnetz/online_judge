package abc194;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		double result = 0;
		
		//確率pで成功する試行が成功するまでの試行回数の期待値は1/p（一応wolframで確認可能）
		//例えば連結成分を1つから2つにする場合は成功する確率は(n - 1)/nなので期待値はn/(n - 1)
		//2つから3つにする場合は成功する確率は(n - 2)/nなので期待値はn/(n - 2)
		//最後の1つは成功する確率は1/nなので期待値はn
		//これらを順に足していく。
		for(int i = 1; i <= n - 1; i++) {
			result += (double)n/(n - i);
		}
		
		System.out.println(result);
	}
	
}
