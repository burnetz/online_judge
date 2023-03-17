package abc293;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		
		//各頂点に接続している辺の数
		int connect[] = new int[n];
		//連結しているかどうかを判断するためのDisjointSet. 環状になっているかは別の方法で判定
		DisjointSet dj = new DisjointSet(n);
		
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt() - 1;
			//赤・青は関係ないので無視
			sc.next();
			int b = sc.nextInt() - 1;
			sc.next();
			
			connect[a]++;
			connect[b]++;
			
			dj.union(a, b);
		}
		
		//グループごとのconnect[]の合計
		int conSumByGroup[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			int groupID = dj.findSet(i);
			conSumByGroup[groupID] += connect[i];
		}
		
		//下のループは重複がありえるのでsetを使うと楽
		HashSet<Integer> ring = new HashSet<Integer>();
		for(int i = 0; i < n; i++) {
			int groupID = dj.findSet(i);
			//環状であればどの頂点もちょうど2本ずつ辺が接続されているはず。
			if(conSumByGroup[groupID] == dj.amountOfOwnGroup(groupID)*2) {
				ring.add(groupID);
			}
		}
		
		System.out.println(ring.size() + " " + ( dj.numOfGroup() - ring.size()));
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