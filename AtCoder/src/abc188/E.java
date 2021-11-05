package abc188;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		
		Node nodes[] = new Node[n];
		Node sorted[] = new Node[n];
		
		for(int i = 0; i < n; i++) {
			nodes[i] = new Node(i, sc.nextInt());
			sorted[i] = nodes[i];
		}
		Arrays.sort(sorted);
		
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] lists = new ArrayList[n];
		for(int i = 0; i < n; i++) {
			lists[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			
			lists[a].add(b);
		}

		boolean visited[] = new boolean[n];
		int result = Integer.MIN_VALUE;
		//始点をvalueの小さい順に選びBFSで試していく。
		//前に試した始点で見た経路上には次以降最適解は見つからないので
		//既に見た頂点を見ないことによって十分間に合う。
		for(int i = 0; i < n; i++) {
			int tmpId = sorted[i].id;
			
			if(visited[tmpId]) {
				continue;
			}
			ArrayDeque<Integer> que = new ArrayDeque<Integer>();
			visited[tmpId] = true;
			que.add(tmpId);
			
			while(!que.isEmpty()) {
				int v = que.removeFirst();
				
				//始点での売却はできないという点に注意する
				if(v != tmpId) {
					result = Math.max(result, nodes[v].value - nodes[tmpId].value);
				}
				
				for(int j = 0; j < lists[v].size(); j++) {
					int u = lists[v].get(j);
					
					if(!visited[u]) {
						visited[u] = true;
						que.add(u);
					}
				}
				
			}
			
			//今回試した始点が別のパターンの終点になることはあり得るので
			//忘れずに訪問履歴を削除しておく。
			visited[tmpId] = false;
			
		}
		
		System.out.println(result);
	}

}

class Node implements Comparable<Node>{
	int id;
	int value;
	
	Node(int id, int value){
		this.id = id;
		this.value = value;
	}

	@Override
	public int compareTo(Node n1) {
		// TODO Auto-generated method stub
		return this.value - n1.value;
	}
	
}