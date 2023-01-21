package abc232;

import java.util.Scanner;


public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		connect = new boolean[n + 1][n + 1];
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			connect[a][b] = connect[b][a] = true;
		}
		
		connect2 = new boolean[n + 1][n + 1];
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			connect2[a][b] = connect2[b][a] = true;
		}
		
		used = new boolean[n + 1];
		numbers = new int[n];
		
		boolean result = dfs(0, n);
		
		System.out.println(result ? "Yes" : "No");
	}
	
	static boolean connect[][];
	static boolean connect2[][];
	
	static boolean used[];
	static int numbers[];
	
	//nが十分小さいので
	//全探索でグラフの一致を確認すればよい。
	static boolean dfs(int currentDepth, int n) {
		if(currentDepth == n) {
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					if(connect[i][j] != connect2[numbers[i - 1]][numbers[j - 1]]) {
						return false;
					}
				}
			}
			return true;
		}
		
		for(int i = 1; i <= n; i++) {
			if(!used[i]) {
				numbers[currentDepth] = i;
				used[i] = true;
				boolean result = dfs(currentDepth + 1, n);
				if(result) {
					return true;
				}
				used[i] = false;
			}
		}
		
		return false;
	}
}