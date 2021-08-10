package abc211;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

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
			int cost = 1;

			edges[from].add( new Edge(to, cost));
			edges[to].add(new Edge(from, cost));
		}

		int[] dist = new int[n];
		long[] pattern = new long[n];
		int mod = 1_000_000_007;
		Arrays.fill(dist, INF);

		ArrayList<Integer> que = new ArrayList<Integer>();

		dist[0] = 0;
		pattern[0] = 1;
		que.add(0);

		//頂点数は多いものの辺の本数はそこまでではないのでBFSでパターン数を確認可能
		while(!que.isEmpty()){
			int v = que.remove(0);

			for(int i = 0; i < edges[v].size(); i++){
				int w = edges[v].get(i).to;

				if(dist[w] == INF){
					dist[w] = dist[v] + 1;
					pattern[w] += pattern[v];
					pattern[w] %= mod;
					que.add(w);
				}
				//普通のBFSには無い処理。今のvからでもwに最短距離で行けるならパターン数に加算
				else if(dist[w] == dist[v] + 1){
					pattern[w] += pattern[v];
					pattern[w] %= mod;
				}
			}
		}

		if(dist[n - 1] == INF){
			System.out.println(0);
			return;
		}
		System.out.println(pattern[n - 1]);
	}

	static final int INF = Integer.MAX_VALUE;
}

class Edge {
	int to;
	int cost;

	Edge(int to, int cost){
		this.to = to;
		this.cost = cost;
	}
}
