package abc219;

import java.util.Arrays;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();

		int a[] = new int[n];
		int b[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		//dp[i][j][k]:i番目までの弁当でたこ焼きj個以上たい焼きk個以上を実現するために最低限必要な弁当数
		int dp[][][] = new int[301][301][301];
		
		for(int i = 0; i < dp.length; i++) {
			for(int j = 0; j < dp[i].length; j++) {
				Arrays.fill(dp[i][j], Integer.MAX_VALUE);
			}
		}
		//初期化（i番目の弁当だけでOKなところを1で埋める）
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <= a[i]; j++) {
				for(int k = 0; k <= b[i]; k++) {
					dp[i][j][k] = 1;
				}
			}
		}
		
		//O(NXY)なので十分間に合う
		for(int i = 1; i < n; i++) {
			for(int j = 0; j <= 300; j++) {
				for(int k = 0; k <= 300; k++) {
					//1つ前の弁当のテーブルでなるべくjとkが小さいところを参照する。
					//インデックスが0よりも小さくなるパターンに注意
					int prev = dp[i - 1][Math.max(0, j - a[i])][Math.max(0, k - b[i])];
					if(prev == Integer.MAX_VALUE) {
						continue;
					}
					
					//i番目の弁当を追加する、i-1番目までのデータをコピー、（できるなら）i番目の弁当しか買わないの中で個数が最小のもの
					dp[i][j][k] = Math.min(Math.min(dp[i][j][k], dp[i - 1][j][k]), prev + 1);
				}
			}
		}
		
		if(dp[n - 1][x][y] != Integer.MAX_VALUE) {
			System.out.println(dp[n - 1][x][y]);
		}
		else {
			System.out.println(-1);
		}
	}

}
