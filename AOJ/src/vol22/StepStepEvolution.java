package vol22;

import java.util.Scanner;

public class StepStepEvolution {
	static int INF = 1_000_000_000;
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		while(true){
			String input = sc.next();

			if(input.equals("#")){
				break;
			}

			int n = input.length();
			//dp[i][j]: i番目で足j（j==0 -> 左 j==1 -> 右）を使ったときの不自然なステップの総数
			int dp[][] = new int[n][2];

			//最初に使う足を決めても最適とは限らないのでDPで解く
			for(int i = 1; i < n; i++){
				int c = input.charAt(i) - '0';
				int prev = input.charAt(i - 1) - '0';

				//例えばこの分岐の場合、右足は使うことができるが左足は絶対に使えない
				if(rowNum(c) > rowNum(prev)){
					dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1] + 1);
					dp[i][0] = INF;
				}
				else if(rowNum(c) < rowNum(prev)){
					dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][0] + 1);
					dp[i][1] = INF;
				}
				else {
					dp[i][0] = Math.min(dp[i - 1][0] + 1, dp[i - 1][1]);
					dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1] + 1);
				}
			}

			System.out.println(Math.min(dp[n - 1][0], dp[n - 1][1]));
		}
	}

	static int rowNum(int c){
		switch (c) {
		case 1:
		case 4:
		case 7:
			return 0;
		case 2:
		case 8:
			return 1;
		default:
			return 2;

		}
	}

}
