package abc292;

import java.util.Arrays;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		
		//どの連結グラフに属しているかの判定用
		DisjointSet dj = new DisjointSet(n);
		//頂点iと接続している辺の本数（inとoutの合計）
		int connect[] = new int[n];
		
		for(int i = 0; i < m; i++) {
			int u = sc.nextInt() - 1;
			int v = sc.nextInt() - 1;
			
			connect[u]++;
			connect[v]++;
			dj.union(u, v);
		}
		
		//各グループごとに各頂点と接続する辺の数を合計したもの
		int connectSum[] = new int[n];
		for(int i = 0; i < n; i++) {
			//dj.findSet(i)でiが属するグループの代表IDを取得できる。
			connectSum[dj.findSet(i)] += connect[i];
		}
		
		for(int i = 0; i < n; i++) {
			int groupID = dj.findSet(i);
			
			//問題の条件を満たしているならグループ内の接続数合計は頂点のちょうど2倍のはず
			if(connectSum[groupID] != dj.amountOfOwnGroup(groupID) * 2) {
				System.out.println("No");
				return;
			}
		}
		System.out.println("Yes");
		
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
	
	//for debug
	public void printPArray() {
		for(int i = 1; i <= n; i++) {
			System.out.print(p[i]+" ");
		}
		System.out.println();
	}
}