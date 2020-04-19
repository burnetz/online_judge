package arc037;

import java.util.HashSet;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		
		DisjointSet ds = new DisjointSet(n + 1);
		
		for(int i = 0; i < m; i++) {
			int u = sc.nextInt() - 1;
			int v = sc.nextInt() - 1;
			
			//閉路を持っている時点でn（実在しない頂点）と同じグループにしてしまう
			if(ds.isSameSet(u, v)) {
				ds.union(u, n);
			}
			
			ds.union(u, v);
		}

		//閉路を持たないもののみグループ番号をsetに格納
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < n; i++) {
			if(!ds.isSameSet(i, n)) {
				set.add(ds.findSet(i));
			}
		}
		
		System.out.println(set.size());
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

	
	//今回はpublicに改造
	public int findSet(int x){
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
