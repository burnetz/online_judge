package abc277;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		
		@SuppressWarnings("unchecked")
		ArrayList<Edge> edges[] = new ArrayList[2*n];

		for(int i = 0; i < edges.length; i++){
			if(edges[i] == null){
				edges[i] = new ArrayList<Edge>();
			}
		}
		
		//辺の状態が変わるのではなく
		//辺の状態が異なる2つのワールドがあると考える。
		for(int i = 0; i < m; i++) {
			int u = sc.nextInt() - 1;
			int v = sc.nextInt() - 1;
			int a = sc.nextInt();
			
			//前半がa = 0のワールド、後半がa = 1のワールド
			int offset = n*a;
			
			//このループで生成される辺は同じワールド内を行き来するためのもの
			edges[u + offset].add(new Edge(v + offset, 1));
			edges[v + offset].add(new Edge(u + offset, 1));
		}
		
		//このループで生成される辺は別ワールドの対応する頂点に移動するためのもの（コストは0）
		for(int i = 0; i < k; i++) {
			int s = sc.nextInt() - 1;
			
			edges[s].add(new Edge(s + n, 0));
			edges[s + n].add(new Edge(s, 0));
		}
		
		//最初はa=1のワールドに属しているので0ではなくnからスタート
		int dist[] = dijkstra(edges, n, 2*n);
		
		int result = Math.min(dist[n - 1], dist[2*n - 1]);
		
		System.out.println(result != INF ? result : -1);
	}

	static final int INF = Integer.MAX_VALUE;

	//ダイクストラ法
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
