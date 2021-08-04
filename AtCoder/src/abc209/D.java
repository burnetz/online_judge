package abc209;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int q = sc.nextInt();
		@SuppressWarnings("unchecked")
		ArrayList<Edge> edges[] = new ArrayList[n];

		for(int i = 0; i < n; i++){
			if(edges[i] == null){
				edges[i] = new ArrayList<Edge>();
			}
		}

		int count[] = new int[n];
		int end = 0;
		//辺の本数がN-1本なので全域木になる
		for(int i = 0; i < n - 1; i++){
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			
			edges[a].add( new Edge(b, 1));
			edges[b].add( new Edge(a, 1));
			count[a]++;
			count[b]++;
		}
		
		//全域木の葉を探す（複数該当する場合どれでもよい）
		for(int i = 0; i < n; i++) {
			if(count[i] == 1) {
				end = i;
				break;
			}
		}
		
		//特定の葉から各点までの距離を求める
		int[] dist = dijkstra(edges, end, n);
		
		//特定の葉からの距離の差の偶奇で答えが決まる
		//葉が複数あることもあるが上記特定の葉からの距離の偶奇は変わらない
		for(int i = 0; i < q; i++) {
			int c = sc.nextInt() - 1;
			int d = sc.nextInt() - 1;
			
			if((dist[c] - dist[d]) % 2 == 0) {
				System.out.println("Town");
			}
			else {
				System.out.println("Road");
			}
		}

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
