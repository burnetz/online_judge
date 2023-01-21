package abc271;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int a[] = new int[n];
		int b[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		int limit = 10000;
		//dp[i][j][k] : i番目のカードをj=0:表orj=1:裏にすることでkにできるか。
		//この構造にすることで後で逆向きにたどることができる。
		boolean dp[][][] = new boolean[n][2][limit + 1];
		
		for(int i = 0; i < n; i++) {
			if(i == 0) {
				dp[0][0][a[0]] = true;
				dp[0][1][b[0]] = true;
				continue;
			}
			//i番目のカードを表にすることで作れる全パターン
			for(int j = a[i]; j <= limit ; j++) {
				if(dp[i - 1][0][j - a[i]] || dp[i - 1][1][j - a[i]]) {
					dp[i][0][j] = true;
				}
			}
			
			//i番目のカードを裏にすることで作れる全パターン
			for(int j = b[i]; j <= limit ; j++) {
				if(dp[i - 1][0][j - b[i]] || dp[i - 1][1][j - b[i]]) {
					dp[i][1][j] = true;
				}
			}
		}
		
		if(!dp[n - 1][0][m] && !dp[n - 1][1][m]) {
			System.out.println("No");
			return;
		}
		else {
			System.out.println("Yes");
		}
		
		boolean nextType = dp[n - 1][0][m];
		StringBuffer sb = new StringBuffer();
		sb.append(nextType ? "H" : "T");
		
		//合計をmにする選び方を逆向きにたどる
		for(int i = n - 1; i >= 1; i--) {
			if(nextType) {
				nextType = dp[i - 1][0][m - a[i]];
				m -= a[i];
			}
			else {
				nextType = dp[i - 1][0][m - b[i]];
				m -= b[i];
			}
			sb.append(nextType ? "H" : "T");
			
		}
		
		System.out.println(sb.reverse());
	}
}