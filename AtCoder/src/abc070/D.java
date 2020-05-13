package abc070;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class D {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		@SuppressWarnings("unchecked")
		ArrayList<Edge> edges[] = new ArrayList[n];

		for(int i = 0; i < n; i++){
			if(edges[i] == null){
				edges[i] = new ArrayList<Edge>();
			}
		}

		String[] tmpArray;
		for(int i = 0; i < n - 1; i++){
			tmpArray = br.readLine().split(" ");
			int from = Integer.parseInt(tmpArray[0]) - 1;
			int to = Integer.parseInt(tmpArray[1]) - 1;
			int cost = Integer.parseInt(tmpArray[2]);

			edges[from].add( new Edge(to, cost));
			edges[to].add( new Edge(from, cost));
		}

		tmpArray = br.readLine().split(" ");
		int q = Integer.parseInt(tmpArray[0]);
		int k = Integer.parseInt(tmpArray[1]) - 1;

		//Kからの全コストを1回調べておけばOK
		long fromK[] = dijkstra(edges, k, n);

		for(int i = 0; i < q; i++){
			tmpArray = br.readLine().split(" ");
			int x = Integer.parseInt(tmpArray[0]) - 1;
			int y = Integer.parseInt(tmpArray[1]) - 1;

			System.out.println(fromK[x] + fromK[y]);
		}
	}

	//今回はコスト最大値が10^14まであり得る
	static final long INF = 1_000_000_000_000_000_0L;

	//ダイクストラ法
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
	long dist;
	int id;

	Distance(long dist, int id){
		this.dist = dist;
		this.id = id;
	}

	@Override
	public int compareTo(Distance d) {

		if(this.dist > d.dist){
			return 1;
		}
		else if(this.dist < d.dist){
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

	Edge(int to, int cost){
		this.to = to;
		this.cost = cost;
	}
}
