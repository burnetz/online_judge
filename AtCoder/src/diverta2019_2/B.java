package diverta2019_2;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		long x[] = new long[n];
		long y[] = new long[n];
		
		for(int i = 0; i < n; i++) {
			x[i] = sc.nextLong();
			y[i] = sc.nextLong();
		}
		
		//明らかに最初の1コストだけで行ける。
		if(n <= 2) {
			System.out.println(1);
			return;
		}
		
		int result = Integer.MAX_VALUE;
		//(p,q)だけ平行移動すれば重なるという同値関係を考えたとき
		//同値類の個数の最小値が答え。
		//N<=50なので全てのp,qを考えても十分間に合う。
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				DisjointSet dj = new DisjointSet(n);
				
				long p = x[i] - x[j];
				long q = y[i] - y[j];
				
				for(int k = 0; k < n; k++) {
					for(int l = k + 1; l < n; l++) {
						long dx = x[k] - x[l];
						long dy = y[k] - y[l];
						
						if((p == dx && q == dy) || (p == -dx && q == -dy)) {
							dj.union(k, l);
						}
					}
				}
				
				result = Math.min(result, dj.numOfGroup());
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