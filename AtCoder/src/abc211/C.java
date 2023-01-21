package abc211;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		
		String chokudai = "chokudai";
		
		//dp[i][j] : 入力文字列のj文字目まででchokudaiのi文字目までを完成させるパターン数
		long dp[][] = new long[chokudai.length() + 1][s.length() + 1];
		//初期化。i文字目までで1文字も選ばない方法は1パターンずつ
		for(int i = 0; i <= s.length(); i++) {
			dp[0][i] = 1;
		}
		
		int mod = 1_000_000_007;
		
		for(int i = 1; i < s.length() + 1; i++) {
			for(int j = 1; j < chokudai.length() + 1; j++) {
				dp[j][i] = dp[j][i - 1];
			}
			
			char tmpC = s.charAt(i - 1);
			
			if(chokudai.contains(tmpC + "")) {
				int index = chokudai.indexOf(tmpC) + 1;
				dp[index][i] += dp[index - 1][i - 1];
				dp[index][i] %= mod;
			}
		}
		
		System.out.println(dp[chokudai.length()][s.length()]);
	}

}
