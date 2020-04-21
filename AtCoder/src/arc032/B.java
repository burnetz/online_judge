package arc032;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		DisjointSet ds = new DisjointSet(n + 1);

		for(int i = 0; i < m; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();

			ds.union(a, b);
		}

		int count = 0;

		//答えはグループ数-1
		//異なるグループを見つけ次第数え上げつつ併合すればよい
		for(int i = 2; i <= n; i++){
			if(!ds.isSameSet(1, i)){
				count++;
				ds.union(1, i);
			}
		}

		System.out.println(count);
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
