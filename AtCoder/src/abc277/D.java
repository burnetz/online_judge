package abc277;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Vector;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		long sum = 0;
		int a[] = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			sum += a[i];
		}

		//どこから始めるのが最適かはこの時点では不明だが
		//・同じカードを出し続ける
		//・同じカードが無いなら次の数字を出す
		//を続けられるだけ行うのが最適。
		//そのため同じ数字あるいは次の数字であるものを同一グループとして扱う。
		DisjointSet2 dj = new DisjointSet2(n);
		Arrays.sort(a);
		for(int i = 0; i < n - 1; i++) {
			if(a[i + 1] - a[i] <= 1) {
				dj.union(i + 1, i + 2);
			}
		}
		
		//先頭と末尾が同じグループなこともある。
		if(a[n - 1] == m - 1 && a[0] == 0) {
			dj.union(1, n);
		}
		
		//各グループごとの総和を計算する。
		long groupSum[] = new long[n + 1];
		
		//グループ番号はfindSetで取得できる。
		for(int i = 0; i < n; i++) {
			groupSum[dj.findSet(i + 1)] += a[i];
		}
		
		long max = 0;
		for(int i = 1; i <= n; i++) {
			max = Math.max(max, groupSum[i]);
		}
		
		System.out.println(sum - max);
	}
	
}

class DisjointSet2 {
	private int n;
	private int[] p;
	private int[] rank;
	//各グループの要素数を管理する
	private int[] num;
	//グループ数を管理する
	private int numOfGroup;

	public DisjointSet2(int n){
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
	
	public void reload() {
		for(int i = 1; i <= n; i++) {
			findSet(i);
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