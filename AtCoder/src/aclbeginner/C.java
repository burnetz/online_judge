package aclbeginner;

import java.util.Arrays;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		//移動にターン制限がないので単純にすべてが同じグループになれば良い。
		//union-findで管理しやすい。
		DisjointSet dj = new DisjointSet(n);

		for(int i = 0; i < m; i++){
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;

			dj.union(a, b);
		}

		int result = 0;

		//孤立したグループをどこに繋げても結果は同じなので
		//とりあえず番号が1つ前の街と繋げる
		for(int i = 1; i < n; i++){
			if(!dj.isSameSet(i, i - 1)){
				result++;
				dj.union(i, i - 1);
			}
		}

		System.out.println(result);
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