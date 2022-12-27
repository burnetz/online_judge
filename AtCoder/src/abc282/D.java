package abc282;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		
		@SuppressWarnings("unchecked")
		Vector<Integer>[] edges = new Vector[n];
		for(int i = 0; i < n; i++) {
			edges[i] = new Vector<Integer>();
		}
		
		//前半のn個が白い頂点、後半のn個が黒い頂点
		DisjointSet dj = new DisjointSet(2*n + 1);
		
		for(int i = 0; i < m; i++) {
			int u = sc.nextInt() - 1;
			int v = sc.nextInt() - 1;
			
			edges[u].add(v);
			edges[v].add(u);
			
			//接続先が既に同じ色であることが確定している場合は問答無用で答えは0
			if(dj.isSameSet(u, v) || dj.isSameSet(u + n, v + n)) {
				System.out.println(0);
				return;
			}
			//白->黒、黒->白両方のパターンを考える
			dj.union(u, v + n);
			dj.union(u + n, v);
		}
		
		//各要素のグループIDを確定させるための処理
		for(int i = 0; i < 2*n; i++) {
			dj.findSet(i);
		}
		
		//各グループに含まれる黒の個数
		int anotherColor[] = new int[2*n];
		
		for(int i = 0; i < n; i++) {
			anotherColor[dj.findSet(i + n)]++;
		}
		
		long result = 0;
		
		//ここからは要素iが白と固定しても問題ない。
		for(int i = 0; i < n; i++) {
			
			//iと接続されていてかつ異なる色のものを数える
			int tmp = 0;
			for(int j = 0; j < edges[i].size(); j++) {
				if(dj.isSameSet(i, edges[i].get(j) + n)) {
					tmp++;
				}
			}
			//まず他の島の要素へは自由に接続できる。
			//あとは同じ島で直接接続されていない黒への本数が追加される。
			result += n - dj.amountOfOwnGroup(i) +  (anotherColor[dj.findSet(i)] - tmp);
		}
		//上記の方法では答えが2倍になるので調整。
		System.out.println(result/2);
	}
}

class DisjointSet {
	private int n;
	private int[] p;
	private int[] rank;
	//各グループの要素数を管理する
	public int[] num;
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