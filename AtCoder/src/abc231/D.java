package abc231;

import java.util.Scanner;

public class D {

	//条件を満たさないのは
	//1. 明らかにある点が3辺とつながるとき　2. グラフがサイクルを持つとき
	//それ以外であれば条件を満たせる
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		
		Edge edges[] = new Edge[m];
		int count[] = new int[n];
		
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			
			edges[i] = new Edge(a, b);
			count[a]++;
			count[b]++;
			if(count[a] > 2 || count[b] > 2) {
				System.out.println("No");
				return;
			}
		}
		
		if(checkCycle(edges, n)) {
			System.out.println("No");
		}
		else {
			System.out.println("Yes");
		}
	}
	
	//グラフがサイクルを持つかチェック
	static boolean checkCycle(Edge[] edges, int n){
		int numOfEdge = edges.length;

		DisjointSet set = new DisjointSet(n);

		for(int i = 0; i < numOfEdge ; i++){
			Edge tmpEdge = edges[i];

			if(!set.isSameSet(tmpEdge.from, tmpEdge.to)){
				set.union(tmpEdge.from, tmpEdge.to);
			}
			else {
				return true;
			}
		}

		return false;

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

class Edge {
	int from;
	int to;

	Edge(int from, int to){
		this.from = from;
		this.to = to;
	}
}
