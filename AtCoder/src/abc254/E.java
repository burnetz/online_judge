package abc254;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Vector;

public class E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		@SuppressWarnings("unchecked")
		Vector<Integer> edges[] = new Vector[n];
		for(int i = 0; i < n; i++) {
			edges[i] = new Vector<Integer>();
		}
		
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			
			edges[a].add(b);
			edges[b].add(a);
		}
		
		int q = sc.nextInt();
		
		for(int i = 0; i < q; i++) {
			int x = sc.nextInt() - 1;
			int k = sc.nextInt();
			
			System.out.println(solve(edges, x, k));
		}
	}		
	
	//距離の制限を決めてBFSで解く。
	//今回の問題は出次数がとても小さいので間に合う。
	static long solve(Vector<Integer>[] edges, int start, int maxDist) {
		long result = 0;
		boolean visited[] = new boolean[edges.length];
		
		result += start + 1;
		
		ArrayDeque<Node> que = new ArrayDeque<Node>();
		que.add(new Node(start, 0));
		visited[start] = true;
		
		for(; !que.isEmpty() ;) {
			Node u = que.removeFirst();
			if(u.time >= maxDist) {
				break;
			}
			for(int j = 0; j < edges[u.id].size(); j++) {
				int tmp = edges[u.id].get(j);
				
				if(!visited[tmp]) {
					result += tmp + 1;
					que.add(new Node(tmp, u.time + 1));
					visited[tmp] = true;
				}
			}
		}
		
		return result;
	}
}

class Node {
	int id;
	int time;
	
	Node(int id, int time){
		this.id = id;
		this.time = time;
	}
}