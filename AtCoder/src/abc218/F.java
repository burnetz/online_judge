package abc218;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class F {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		//0 origin
		int n = sc.nextInt();
		int m = sc.nextInt();

		@SuppressWarnings("unchecked")
		ArrayList<MyEdge> edges[] = new ArrayList[n];

		for(int i = 0; i < n; i++){
			if(edges[i] == null){
				edges[i] = new ArrayList<MyEdge>();
			}
		}

		MyEdge[] referEdges = new MyEdge[m];
		for(int i = 0; i < m; i++){
			int from = sc.nextInt() - 1;
			int to = sc.nextInt() - 1;
			int cost = 1;

			MyEdge tmpEdge =  new MyEdge(to, cost);
			edges[from].add(tmpEdge);
			//いつでももともとの順番で各辺を参照できるようにする。
			referEdges[i] = tmpEdge;
		}

		//コスト変更を行わなかった場合の最短距離を調べる
		int tmpDist[] = dijkstra(edges, 0, n, true);
		int minDist = tmpDist[n - 1];

		int tmpTo = n - 1;

		//最短ルートを再構築し、利用した辺のフラグにtrueを設定する。
		if(minDist != INF){
			for(int i = 0; i < n; i++){
				if(tmpTo == 0){
					break;
				}

				int tmpFrom = minRoute[tmpTo];
				for(int j = 0; j < edges[tmpFrom].size(); j++){
					MyEdge tmpEdge = edges[tmpFrom].get(j);

					if(tmpEdge.to == tmpTo){
						tmpEdge.minimum = true;
						tmpTo = tmpFrom;
						break;
					}
				}
			}
		}

		int prevDist = 0;
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < m; i++){
			if(i > 0){
				referEdges[i - 1].cost = prevDist;
			}
			prevDist = referEdges[i].cost;
			//実際に辺を削除するのは大変なのでコストを大幅に上げることで代用
			//このくらいの値にすれば今回の問題ではまず選ばれなくなる。
			referEdges[i].cost = 100000;

			//最短ルートに含まれない辺を削除しても最短距離は変わらないので特に何も計算しない。
			//密グラフの場合圧倒的多数がこちらの分岐になる。
			if(!referEdges[i].minimum){
				sb.append((minDist > 100000 ? -1 : minDist) + "\n");
			}
			//最短ルート上の辺を削除した場合は普通に計算しなおす。
			//高々N-1回しかこちらの分岐には入らないので間に合う。
			else {
				int[] dist = dijkstra(edges, 0, n, false);

				sb.append((dist[n - 1] > 100000 ? -1 : dist[n - 1]) + "\n");
			}
		}

		System.out.print(sb);

	}


	static final int INF = Integer.MAX_VALUE;
	static int[] minRoute;

	//ダイクストラ法
	static int[] dijkstra(ArrayList<MyEdge>[] edges, int s, int n, boolean checkMinimum){
		//各頂点への最短ルート上での直前の頂点番号を調べるための配列
		if(checkMinimum){
			minRoute = new int[n];
			Arrays.fill(minRoute, -1);
		}

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
				MyEdge e = (MyEdge) edges[tmpV].get(i);
				if(dist[e.to] > dist[tmpV] + e.cost){
					dist[e.to] = dist[tmpV] + e.cost;
					que.add(new Distance(dist[e.to], e.to));

					if(checkMinimum){
						minRoute[e.to] = tmpV;
					}
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


class MyEdge {
	int to;
	int cost;
	boolean minimum;

	MyEdge(int to, int cost){
		this.to = to;
		this.cost = cost;
	}
}
