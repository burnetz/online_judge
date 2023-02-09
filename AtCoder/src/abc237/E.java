package abc237;

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
		
		int h[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			h[i] = sc.nextInt();
		}
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
			int cost1, cost2;
			
			//普通に計算すると負の値が発生してダイクストラでは解けないため
			//上りのときだけコストとして計上する。
			//その際、最適な解であれば上って終わることはありえないので
			//下りでのキャンセルを考慮して2倍せずに単に差を用いる。
			if(h[from] >= h[to]) {
				cost1 = 0;
				cost2 = h[from] - h[to];
			}
			else {
				cost1 = h[to] - h[from];
				cost2 = 0;
			}

			edges[from].add( new Edge(to, cost1));
			edges[to].add( new Edge(from, cost2));
		}
		
		long dist[] = dijkstra(edges, 0, n);
		
		long result = INF;
		
		//コスト込みでの擬似的な高さの最小値を求める。
		//例えば途中で一度も上りがなかったなら単純にh[0]との差で最終的に計算できる。
		//それ以外のパターンのためにコストの計上が必要
		for(int i = 0; i < n; i++) {
			result = Math.min(result, dist[i] + h[i]);
		}
		
		System.out.println(h[0] - result);
	}
	
	static final long INF = 1_000_000_000_000_000L;

	//ベルマンフォードでは間に合わないのでダイクストラ法を使う。
	//上りのときのみコストが発生すると解釈すれば全ての辺が非負なので適用できる。
	static long[] dijkstra(ArrayList<Edge>[] edges, int s, int n){

		PriorityQueue<Distance> que = new PriorityQueue<Distance>();
		long[] dist = new long[n];

		Arrays.fill(dist, INF);
		dist[s] = 0;
		que.add(new Distance(0, s));

		while(!que.isEmpty()){
			Distance tmpDist = que.poll();
			int tmpV = tmpDist.id;

			if(dist[tmpV] < tmpDist.cost){
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
	long cost;
	int id;

	Distance(long dist, int id){
		this.cost = dist;
		this.id = id;
	}

	@Override
	public int compareTo(Distance d) {
		return this.cost == d.cost ? 0 :
			this.cost > d.cost ? 1 : -1;
	}
}

class Edge {
	int to;
	long cost;

	Edge(int to, int cost){
		this.to = to;
		this.cost = cost;
	}
}
