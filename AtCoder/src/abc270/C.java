package abc270;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int x = sc.nextInt() - 1;
		int y = sc.nextInt() - 1;
		
		prev = new int[n];
		@SuppressWarnings("unchecked")
		ArrayList<Edge> edges[] = new ArrayList[n];

		for(int i = 0; i < n; i++){
			if(edges[i] == null){
				edges[i] = new ArrayList<Edge>();
			}
		}

		for(int i = 0; i < n - 1; i++){
			int u = sc.nextInt() - 1;
			int v = sc.nextInt() - 1;

			edges[u].add( new Edge(v, 1));
			edges[v].add( new Edge(u, 1));
		}
		
		int dist[] = dijkstra(edges, x, n);
		
		int path[] = new int[dist[y] + 1];
		int v = y;
		for(int i = dist[y] ; i >= 0; i--) {
			path[i] = v;
			v = prev[v];
		}
		
		for(int i = 0; i < path.length; i++) {
			System.out.print(path[i] + 1 + " ");
		}
		System.out.println();
	}
	static final int INF = Integer.MAX_VALUE;
	static int prev[];

	//ダイクストラ法
	//最短経路選択時の各頂点の直前を保持できるよう改修
	static int[] dijkstra(ArrayList<Edge>[] edges, int s, int n){

		PriorityQueue<Distance> que = new PriorityQueue<Distance>();
		int[] dist = new int[n];

		Arrays.fill(dist, INF);
		dist[s] = 0;
		que.add(new Distance(0, s));

		while(!que.isEmpty()){
			Distance tmpDist = que.poll();
			int tmpV = tmpDist.id;

			if(dist[tmpV] < tmpDist.dist){
				continue;
			}
			for(int i = 0; i < edges[tmpV].size() ; i++){
				Edge e = (Edge) edges[tmpV].get(i);
				if(dist[e.to] > dist[tmpV] + e.cost){
					dist[e.to] = dist[tmpV] + e.cost;
					que.add(new Distance(dist[e.to], e.to));
					prev[e.to]= tmpV; 
				}
			}
		}

		return dist;
	}
}

class Distance implements Comparable<Distance>{
	int dist;
	int id;

	Distance(int dist, int id){
		this.dist = dist;
		this.id = id;
	}

	@Override
	public int compareTo(Distance d) {
		return this.dist - d.dist;
	}
}

class Edge {
	int to;
	int cost;

	Edge(int to, int cost){
		this.to = to;
		this.cost = cost;
	}
}
