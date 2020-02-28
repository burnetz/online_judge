package abc145;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		pos = new int[n][2];
		
		for(int i = 0; i < n; i++) {
			pos[i][0] = sc.nextInt();
			pos[i][1] = sc.nextInt();
		}
		
		visit = new boolean[n];
		index = new int[n];
		
		dfs(0, n);
		
		System.out.println(result/fact(n));
	}
	
	static double result = 0;
	
	static int pos[][];

	static boolean visit[];
	static int index[];
	
	//全探索で解く。N<=8なので十分間に合う
	static void dfs(int depth, int n) {
		if(depth == n) {
			for(int i = 0; i < n - 1; i++) {
				result += Math.sqrt(Math.pow(pos[index[i]][0] - pos[index[i + 1]][0], 2)
						+ Math.pow(pos[index[i]][1] - pos[index[i + 1]][1], 2));
			}
			
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				index[depth] = i;
				dfs(depth + 1, n);
				visit[i] = false;
			}
		}
	}
	
	static long fact(int n) {
		if(n == 0) {
			return 1;
		}
		
		long result = 1;
		for(int i = 1; i <= n; i++) {
			result *= i;
		}
		
		return result;
	}
}
