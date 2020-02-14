package abc149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmpArray = br.readLine().split(" ");
		int n = Integer.parseInt(tmpArray[0]);
		int k = Integer.parseInt(tmpArray[1]);
		
		tmpArray = br.readLine().split(" ");
		int r = Integer.parseInt(tmpArray[0]);
		int s = Integer.parseInt(tmpArray[1]);
		int p = Integer.parseInt(tmpArray[2]);
		
		String input = br.readLine();
		
		//dp[i][j] i回目にr(0),s(1),t(2)のいずれかを出したときの最大値
		int[][] dp = new int[n][3];
		
		for(int i = 0; i < n; i++) {
			char tmpC = input.charAt(i);
			
			int tmpMax = 0;
			if(i >= 1) {
				for(int j = 0; j < 3; j++) {
					tmpMax = Math.max(tmpMax, dp[i - 1][j]);
				}
			}
			//勝ち負け関係なく1ターン前の最大値を加算しておく
			Arrays.fill(dp[i], tmpMax);
			
			//敵がグー
			if(tmpC == 'r') {
				//自分がパーのときだけ加算
				dp[i][2] += p;
				//ｋ回前にパーを出した場合が最大値だったならｋ回前にパー以外を出したことにする
				//パー以外なら間違いなく0点なのでただ減算するだけでよい
				if(i >= k && dp[i - k][2] > dp[i - k][0] && dp[i - k][2] > dp[i - k][1]) {
					dp[i][2] -= p;
				}
			}
			else if(tmpC == 's') {
				dp[i][0] += r;
				if(i >= k && dp[i - k][0] > dp[i - k][1] && dp[i - k][0] > dp[i - k][2]) {
					dp[i][0] -= r;
				}
			}
			else {
				dp[i][1] += s;
				if(i >= k && dp[i - k][1] > dp[i - k][0] && dp[i - k][1] > dp[i - k][2]) {
					dp[i][1] -= s;
				}
			}
			
		}
		
		System.out.println(Math.max(dp[n-1][0], Math.max(dp[n-1][1], dp[n-1][2])));
	}
}
