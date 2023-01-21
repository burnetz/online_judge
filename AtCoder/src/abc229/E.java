package abc229;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		
		//グループの総数を取得できるよう改良したunion-find
		DisjointSet dj = new DisjointSet(n);
		
		@SuppressWarnings("unchecked")
		ArrayList<Edge>[] lists = new ArrayList[n + 1];
		for(int i = 0; i < n + 1; i++) {
			lists[i] = new ArrayList<Edge>();
		}
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			lists[a].add(new Edge(b));
			lists[b].add(new Edge(a));
		}
		
		int result[] = new int[n + 2];
		result[n + 1] = 0;
		//グラフを逆の手順で構築した方がわかりやすい。
		//なお、番号の小さいノードはそもそも見えていないことに注意する。
		for(int i = n; i >= 1; i--) {
			for(int j = 0; j < lists[i].size(); j++) {
				Edge tmp = lists[i].get(j);
				
				if(tmp.to > i) {
					dj.union(i, tmp.to);
				}
			}
			//グループ数から見えていないノードを引いたものが結果
			result[i] = dj.numOfGroup() - (i - 1);
		}
		
		StringBuffer sb = new StringBuffer();
		for(int i = 2; i <= n + 1; i++) {
			sb.append(result[i] + "\n");
		}
		
		System.out.print(sb);
	}

}

class DisjointSet {
	private int n;
	private int[] p;
	private int[] rank;
	//各グループの要素数を管理する
	private int[] num;
	//グループ数を管理する
	private int numOfGroup;

	public DisjointSet(int n){
		this.n = n;

		p = new int[n + 1];
		rank = new int[n + 1];

		num = new int[n + 1];
		
		Arrays.fill(num, 1);
		
		for(int i = 1; i <= n; i++){
			makeSet(i);
		}
		
		numOfGroup = n;
	}

	private void makeSet(int x){
		p[x] = x;
		rank[x] = 0;
	}

	public void union(int x, int y){
		int p1 = findSet(x), p2 = findSet(y);
		int num1 = num[p1];
		int num2 = num[p2];
		link (findSet(x), findSet(y));
		
		if(p1 != p2) {
			num[p1] = num[p2] = num1 + num2;
			numOfGroup--;
		}
	}
	
	public int amountOfOwnGroup(int x) {
		return num[findSet(x)];
	}

	public int numOfGroup() {
		return numOfGroup;
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
	
	//for debug
	public void printPArray() {
		for(int i = 1; i <= n; i++) {
			System.out.print(p[i]+" ");
		}
		System.out.println();
	}
}

class Edge {
	int to;
	
	Edge(int to){
		this.to = to;
	}
}

