package abc226;

import java.util.ArrayList;
import java.util.Scanner;


public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();

		@SuppressWarnings("unchecked")
		ArrayList<Integer> lists[] = new ArrayList[n + 1];
		for(int i = 0; i < n + 1; i++) {
			lists[i] = new ArrayList<Integer>();
		}
		
		visited = new boolean[n + 1];
		int time[] = new int[n + 1];
		
		//過去の技に遡ることしかできないようにリストを作る。
		for(int i = 1; i <= n; i++) {
			time[i] = sc.nextInt();

			int k = sc.nextInt();
			
			for(int j = 0; j < k; j++) {
				int tmp = sc.nextInt();
				lists[i].add(tmp);
			}
		}
		//dfsで技nのために必要な全ての技を遡れる。
		dfs(lists, n);
		
		long result = 0;
		
		for(int i = 0; i <= n; i++) {
			if(visited[i]) {
				result += time[i];
			}
		}
		
		System.out.println(result);
		
	}
	
	static boolean visited[];
	
	static void dfs(ArrayList<Integer>[] lists, int v) {
		visited[v] = true;
		
		for(int i = 0; i < lists[v].size(); i++) {
			int u = lists[v].get(i);
			
			if(!visited[u]) {
				dfs(lists, u);
			}
		}
	}
}