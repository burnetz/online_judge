package abc286;

import java.util.HashMap;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int x = sc.nextInt();
		
		boolean dp[][] = new boolean[n][x + 1];
		
		//n,x,bの制約が緩いので普通にDPで求められる。
		for(int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			for(int j = 0; j <= b; j++) {
				if(i == 0 && j*a <= x) {
					dp[0][j*a] = true;
				}
				
				else if(i >= 1){
					for(int k = 0; k <= x; k++) {
						if(dp[i - 1][k] && k + j*a <= x) {
							dp[i][k + j*a] = true;
						}
					}
				}
			}
		}
		
		System.out.println(dp[n - 1][x] ? "Yes" : "No");
	}
}