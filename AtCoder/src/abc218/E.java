package abc218;

import java.util.Arrays;
import java.util.Scanner;

public class E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		Edge edges[] = new Edge[m];
		long plusSum = 0;

		for(int i = 0; i < m; i++){
			int from = sc.nextInt();
			int to = sc.nextInt();
			int cost = sc.nextInt();

			plusSum += Math.max(cost, 0);
			//コストが負だった場合は敢えて0にしておく。
			//最終的なグラフを考えたときに負と0は全て残して良いため。
			edges[i] = new Edge(from,to, Math.max(cost, 0));
		}

		//求める答えは「正のコストの和」-「最小全域木のコストの和」
		System.out.println(plusSum - kruskal(edges, n));
	}

	static final int INF = Integer.MAX_VALUE;


	static long kruskal(Edge[] edges, int n){
		int numOfEdge = edges.length;

		Arrays.sort(edges);

		DisjointSet set = new DisjointSet(n);

		long result = 0;

		for(int i = 0; i < numOfEdge ; i++){
			Edge tmpEdge = edges[i];

			if(!set.isSameSet(tmpEdge.from, tmpEdge.to)){
				set.union(tmpEdge.from, tmpEdge.to);
				result += tmpEdge.cost;
			}
		}

		return result;

	}

}

class DisjointSet {
    private int n;
    private int[] p;
    private int[] rank;

    public DisjointSet(int n){
        this.n = n;

        p = new int[n + 1];
        rank = new int[n + 1];

        for(int i = 1; i <= n; i++){
            makeSet(i);
        }
    }

    private void makeSet(int x){
        p[x] = x;
        rank[x] = 0;
    }

    public void union(int x, int y){
        link (findSet(x), findSet(y));
    }

    private int findSet(int x){
        if(x != p[x]){
            p[x] = findSet( p[x]);
        }
        return p[x];
    }

    public boolean isSameSet(int x, int y){
        return findSet(x) == findSet(y);
    }

    private void link(int x, int y){
        if(rank[x] > rank[y]){
            p[y] = x;
        }
        else {
            p[x] = y;
            if(rank[x] == rank[y]){
                rank[y]++;
            }
        }
    }
}

class Edge implements Comparable<Edge>{
	int from;
	int to;
	int cost;

	Edge(int from, int to, int cost){
		this.from = from;
		this.to = to;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge e) {
		return this.cost - e.cost;
	}
}