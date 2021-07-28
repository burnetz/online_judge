package abc204;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		@SuppressWarnings("unchecked")
		ArrayList<Edge> edges[] = new ArrayList[n];

		for(int i = 0; i < n; i++){
			edges[i] = new ArrayList<Edge>();
		}

		for(int i = 0; i < m; i++){
			int from = sc.nextInt() - 1;
			int to = sc.nextInt() - 1;
			int cost = 1;

			edges[from].add( new Edge(to, cost));
		}

		//warshall-floydだと間に合わない
		//辺の数は少ないのでダイクストラをn回なら間に合う
		int count = 0;
		for(int i = 0; i < n; i++) {
			int[] tmpResult = dijkstra(edges, i, n);
			
			for(int j = 0 ; j < n; j++) {
				if(tmpResult[j] != INF) {
					count++;
				}
			}
		}

		System.out.println(count);
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