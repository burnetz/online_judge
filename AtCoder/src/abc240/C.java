package abc240;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int x = sc.nextInt();
		int limit = 10000;
		//2^100は間に合わないのでdpで解く
		boolean dp[][] = new boolean[n + 1][limit + 1];
		dp[0][0] = true;
		
		for(int i = 1; i <= n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			for(int j = 0; j <= limit; j++) {
				if(!dp[i - 1][j]) {
					continue;
				}
				
				if(j + a <= limit) {
					dp[i][j + a] = true;
				}
				if(j + b <= limit) {
					dp[i][j + b] = true;
				}
			}
		}
		
		System.out.println(dp[n][x] ? "Yes" : "No");
	}
}