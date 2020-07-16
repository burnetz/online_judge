package abc142;

import java.util.Arrays;
import java.util.Scanner;

public class E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		//dp[i] : iで表せるパターンにおける金額の最小値
		int dp[] = new int[(int)Math.pow(2, n)];
		int INF = 1_000_000_000;
		Arrays.fill(dp, INF);
		dp[0] = 0;
		for(int i = 0; i < m; i++){
			int price = sc.nextInt();
			int b = sc.nextInt();

			//この鍵で開けられる組み合わせを1つの整数で表す
			int pattern = 0;
			for(int j = 0; j < b; j++){
				int c = sc.nextInt();
				pattern += Math.pow(2, c - 1);
			}

			//最悪でも4096パターンなので十分間に合う
			for(int j = 0; j < dp.length; j++){
				//開けられる組み合わせの部分集合であるなら必要に応じて最小値を鍵の金額で更新
				if((pattern | j) == pattern){
					dp[j] = Math.min(dp[j], price);
				}
				//部分集合でないなら組み合わせて別の開け方の最小金額を求める
				else {
					dp[pattern|j] = Math.min(dp[pattern|j], dp[j] + price);
				}
			}
		}
		if(dp[dp.length - 1] < INF){
			System.out.println(dp[dp.length - 1]);
		}
		else {
			System.out.println(-1);
		}
	}

}
