package abc213;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Vector;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		//普通のリストとして持とうとすると番号でのソート時にTLEになりそう。
		//一度見た辺は捨てて良いので優先度付きキューで管理する
		@SuppressWarnings("unchecked")
		PriorityQueue<Edge> edges[] = new PriorityQueue[n];

		for(int i = 0; i < n; i++){
			if(edges[i] == null){
				edges[i] = new PriorityQueue<Edge>();
			}
		}

		for(int i = 0; i < n - 1; i++){
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			
			edges[a].add(new Edge(b, 1));
			edges[b].add(new Edge(a, 1));
		}
		route = new Vector<Integer>();
		visited = new boolean[n];

		dfs(edges, 0);
		
		//出力のせいでTLEになるので可能な限りの高速化をする
		Iterator<Integer> it = route.iterator();
		StringBuffer sb = new StringBuffer();
		while(it.hasNext()) {
			if(sb.length() != 0) {
				sb.append(" ");
			}
			sb.append(it.next() + 1);
		}
		
		System.out.println(sb);
	}
	static Vector<Integer> route;
	static boolean visited[];
	static void dfs(PriorityQueue<Edge>[] edges, int from) {
		visited[from] = true;
		route.add(from);
		
		//この過程で辺の情報が捨てられていくが
		//同じ辺を見る予定はもともと無かったので問題はない
		while(!edges[from].isEmpty()) {
			Edge tmpEdge = edges[from].remove();
			if(!visited[tmpEdge.to]) {
				dfs(edges, tmpEdge.to);
				route.add(from);
			}
		}
		
	}
}

class Edge implements Comparable<Edge>{
	int to;
	int cost;

	Edge(int to, int cost){
		this.to = to;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge e1) {
		// TODO Auto-generated method stub
		return this.to - e1.to;
	}
}
