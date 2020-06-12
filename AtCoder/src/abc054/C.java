package abc054;

import java.util.Scanner;

public class C {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		matrix = new boolean[n][n];

		for(int i = 0; i < m; i++){
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;

			matrix[a][b] = true;
			matrix[b][a] = true;
		}

		visit = new boolean[n];

		dfs(0);

		System.out.println(result);
	}

	static boolean matrix[][];
	static boolean visit[];
	static int result = 0;

	//頂点数が少ないので全探索で網羅できる
	static void dfs(int v){
		visit[v] = true;

		int n = visit.length;

		boolean end = true;

		for(int i = 0; i < n; i++){
			if(!visit[i] && matrix[v][i]){
				end = false;
				dfs(i);
			}
		}

		if(end){
			int count = 0;
			for(int i = 0; i < n; i++){
				if(visit[i]){
					count++;
				}
			}

			if(count == n){
				result++;
			}
		}

		visit[v] = false;
	}
}