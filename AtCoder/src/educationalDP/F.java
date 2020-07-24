package educationalDP;

import java.util.Scanner;

public class F {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		char[] s = sc.next().toCharArray();
		char[] t = sc.next().toCharArray();

		int dp[][] = new int[s.length + 1][t.length + 1];

		for(int i = 1; i <= s.length; i++){
			for(int j = 1; j <= t.length; j++){
				dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);

				if(s[i - 1] == t[j - 1]){
					dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i][j]);
				}

			}
		}

		String result = "";

		int i = s.length;
		int j = t.length;
		while(i > 0 && j > 0){
			if(dp[i][j] == dp[i][j - 1]){
				j--;
			}
			else if(dp[i][j] == dp[i - 1][j]){
				i--;
			}
			else {
				result = s[i - 1] + result;
				i--;
				j--;
			}
		}
		System.out.println(result);
	}

}
