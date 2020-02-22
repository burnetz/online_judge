package abc153;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class E {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmpArray = br.readLine().split(" ");
		
		int h = Integer.parseInt(tmpArray[0]);
		int n = Integer.parseInt(tmpArray[1]);

		int damage[] = new int[n];
		int cost[] = new int[n];
		
		int dp[] = new int[10000 + 1];
		
		for(int i = 0; i < n; i++) {
			tmpArray = br.readLine().split(" ");
			
			damage[i] = Integer.parseInt(tmpArray[0]);
			cost[i] = Integer.parseInt(tmpArray[1]);
		}
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		//与えられるダメージと魔法のコストでナップサック問題を考える
		//2重ループで十分間に合う
		for(int i = 1; i <= 10000; i++) {
			for(int j = 0; j < n; j++) {
				dp[i] = Math.min(dp[i], dp[i - Math.min(i, damage[j])] + cost[j]);
			}
		}
				
		System.out.println(dp[h]);
	}

}
