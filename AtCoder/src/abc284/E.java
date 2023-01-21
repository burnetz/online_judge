package abc284;

import java.util.Scanner;
import java.util.Vector;

public class E {
 
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		edges = new Vector[n];
		visited = new boolean[n];
		
		for(int i = 0; i < n; i++) {
			edges[i] = new Vector<Integer>();
		}
		
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			
			edges[a].add(b);
			edges[b].add(a);
		}
		
		dfs(0);
		
		System.out.println(result);
	}		
	
	static int result = 0;
	static int limit = 1000000;
	@SuppressWarnings("rawtypes")
	static Vector[] edges;
	static boolean visited[];
	
	//DFSでの探索自体は非常に時間がかかるが
	//今回の問題ではlimit到達時にただちに終了することができる。
	static void dfs(int pos) {
		visited[pos] = true;
		result++;
		if(result == limit) {
			System.out.println(limit);
			System.exit(0);
		}
		
		for(int i = 0; i < edges[pos].size(); i++) {
			int to = (int) edges[pos].get(i);
			
			if(visited[to] == false) {
				dfs(to);
			}
		}
		
		visited[pos] = false;
	}
}