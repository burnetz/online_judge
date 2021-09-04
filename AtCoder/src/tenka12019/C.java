package tenka12019;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String str = sc.next();

		//dp[0][j] j文字目を白にする dp[1][j] j文字目を黒にする
		int dp[][] = new int[2][n];

		if(str.charAt(0) == '.'){
			dp[1][0] = 1;
		}
		else{
			dp[0][0] = 1;
		}

		for(int i = 1; i < n; i++){
			char c = str.charAt(i);

			//i文字目を白くできるのは直前が白い場合のみ
			dp[0][i] = dp[0][i - 1];
			if(c == '#'){
				dp[0][i]++;
			}

			//i文字目を黒にするのは直前は何色でも良いので手数が少ない方を選ぶ
			dp[1][i] = Math.min(dp[0][i - 1], dp[1][i - 1]);
			if(c == '.'){
				dp[1][i]++;
			}
		}

		System.out.println(Math.min(dp[0][n - 1], dp[1][n - 1]));
	}
}
