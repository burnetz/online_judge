package arc134;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		char[] str = sc.next().toCharArray();
		
		//dp[i][j] : i文字目までで最後に文字jが現れた場所
		int dp[][] = new int[n][26];
		Arrays.fill(dp[0], -1);
		dp[0][str[0] - 'a'] = 0;
		
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < 26; j++) {
				dp[i][j] = dp[i - 1][j];
			}
			dp[i][str[i] - 'a'] = i;
			
		}
		
		//文字列を前から順に見て
		//例えばaなどできるだけ小さい文字とスワップできるならする。
		//このときtailが一気に小さくなっても構わないので最も小さい文字を出し惜しみしない（小さい文字を温存する意味がない）。
		//テーブルに記録済みなのでO(N)で可能
		int tail = n - 1;
		for(int i = 0; i < tail; i++) {
			for(int j = 0; j < 26; j++) {
				if(dp[tail][j] > i && str[i] > j + 'a') {
					tail = dp[tail][j];
					char tmp = str[i];
					str[i] = str[tail];
					str[tail] = tmp;
					tail--;
					break;
				}
			}
		}
		
		System.out.println(str);
	}
}