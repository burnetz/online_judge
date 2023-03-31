package abc295;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		int n = str.length();
		if(n == 1) {
			System.out.println(0);
			return;
		}
		int array[] = new int[n];
		//dp[i][j] : i = 1が最新、i = 0がその直前。jは0~9までの数字の登場回数の偶奇を2進数で表したもの。
		//N*1024で確保しようとするとメモリ不足で落ちる。
		//計算の際に直前までしか見ないので片方をバッファとして2*1024確保すれば十分
		int dp[][] = new int[2][1024];
		
		long result = 0;
		//i番目までの全ての数字のXORをとったもの。
		int latest = 0;
		//区間の長さが0でも0000000000は作れる。
		dp[0][0] = 1;
		for(int i = 0; i < n; i++) {
			array[i] = str.charAt(i) - '0';
			int mask = 1 << array[i];
			latest ^= mask;
			dp[1][latest]++;
			for(int j = 0; j < 1024; j++) {
				dp[1][j] += dp[0][j];
			}

			//ここまでの全てのXORであるlatestを打ち消すことができるのは同じビット配列を持つもの
			result += dp[0][latest];

			//バッファの移し替え
			for(int j = 0; j < 1024; j++) {
				dp[0][j] = dp[1][j];
				dp[1][j] = 0;
			}
		}
		
		System.out.println(result);
	}

}
