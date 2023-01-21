package abc244;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int s = sc.nextInt() - 1;
		int t = sc.nextInt() - 1;
		int x = sc.nextInt() - 1;
		
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] list = new ArrayList[n];
		
		for(int i = 0; i < n; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < m; i++) {
			int u = sc.nextInt() - 1;
			int v = sc.nextInt() - 1;
			
			list[u].add(v);
			list[v].add(u);
		}
		
		int mod =  998244353;
		
		//dp[i][j][k] : iターン目に頂点jに行くパターン数。k = 0はXの経由数偶数、k = 1は奇数回
		long dp[][][] = new long[k + 1][n][2];
		dp[0][s][0] = 1;
		
		//辺の数がM<=2000なのでO(N^3)ではなくO(NM)
		for(int i = 1; i <= k; i++) {
			for(int j = 0; j < n; j++) {
				Iterator<Integer> it = list[j].iterator();
				
				//頂点jがXと一致しているかどうかで参照すべき値が変わる
				int offset = j == x ? 1 : 0;
				while(it.hasNext()) {
					int from = it.next();
					
					dp[i][j][0] += dp[i - 1][from][offset];
					dp[i][j][0] %= mod;
					dp[i][j][1] += dp[i - 1][from][(offset + 1)%2];
					dp[i][j][1] %= mod;
				}
			}
		}
		
		System.out.println(dp[k][t][0]);
	}
}
