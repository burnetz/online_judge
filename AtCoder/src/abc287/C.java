package abc287;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		int m = sc.nextInt();
		
		//パスグラフは木構造でもあるので辺はn-1本のはず。
		if(m != n - 1) {
			System.out.println("No");
			return;
		}
		
		//頂点iを参照した回数。パスグラフなら1回しか参照されない頂点が2つ、他は2回ずつ。
		int count[] = new int[n];
		
		//上の条件だけでは不十分。全部が同じグループになったかを確認する必要がある。
		DisjointSet dj = new DisjointSet(n);

		for(int i = 0; i < m; i++) {
			int u = sc.nextInt() - 1;
			int v = sc.nextInt() - 1;
			
			dj.union(u, v);
			count[u]++;
			count[v]++;
		}
		
		int one = 0;
		for(int i = 0; i < n; i++) {
			if(count[i] != 1 && count[i] != 2) {
				System.out.println("No");
				return;
			}
			
			if(count[i] == 1) {
				one++;
			}
		}
		
		if(one == 2 && dj.numOfGroup() == 1) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
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

