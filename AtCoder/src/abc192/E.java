package abc192;

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
		int x = sc.nextInt() - 1;
		int y = sc.nextInt() - 1;
		
		@SuppressWarnings("unchecked")
		ArrayList<Edge> edges[] = new ArrayList[n];

		for(int i = 0; i < n; i++){
			if(edges[i] == null){
				edges[i] = new ArrayList<Edge>();
			}
		}

		for(int i = 0; i < m; i++){
			int from = sc.nextInt() - 1;
			int to = sc.nextInt() - 1;
			int cost = sc.nextInt();
			int interval = sc.nextInt();

			edges[from].add( new Edge(to, cost, interval));
			edges[to].add( new Edge(from, cost, interval));
		}
		
		long dist[] = dijkstra(edges, x, n);
		
		if(dist[y] == INF) {
			System.out.println(-1);
		}
		else {
			System.out.println(dist[y]);
		}
	}
	static final long INF = 1_000_000_000_000_000L;
	

	//通常のダイクストラ法をベースにして
	//距離の比較に関わる箇所を改造すればOK
	static long[] dijkstra(ArrayList<Edge>[] edges, int s, int n){

		PriorityQueue<Distance> que = new PriorityQueue<Distance>();
		long[] dist = new long[n];

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
				//customize
				//次にtmpVから出発する時刻の計算をしておく
				long depart = dist[tmpV] + (e.interval - dist[tmpV]%e.interval)%e.interval;
				if(dist[e.to] > depart + e.cost){
					dist[e.to] = depart + e.cost;
					que.add(new Distance(dist[e.to], e.to));
				}
			}
		}

		return dist;
	}
}

class Distance implements Comparable<Distance>{
	long dist;
	int id;

	Distance(long dist, int id){
		this.dist = dist;
		this.id = id;
	}

	@Override
	public int compareTo(Distance d) {
		if(this.dist > d.dist) {
			return 1;
		}
		else if(this.dist < d.dist) {
			return -1;
		}
		else {
			return 0;
		}
	}
}

class Edge {
	int to;
	int cost;
	int interval; //customize

	//customize
	Edge(int to, int cost, int interval){
		this.to = to;
		this.cost = cost;
		this.interval = interval;
	}
}
