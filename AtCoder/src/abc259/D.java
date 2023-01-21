package abc259;

import java.util.Arrays;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		long sx = sc.nextLong();
		long sy = sc.nextLong();
		long tx = sc.nextLong();
		long ty = sc.nextLong();
		
		Circle circles[] = new Circle[n];
		
		for(int i = 0; i < n; i++) {
			circles[i] = new Circle(sc.nextLong(), sc.nextLong(), sc.nextLong());
		}
		
		DisjointSet dj = new DisjointSet(n + 2);
		
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				long dx = circles[i].x - circles[j].x;
				long dy = circles[i].y - circles[j].y;
				long dist = dx*dx + dy*dy;
				
				//交点を持つ円の周上は相互に移動できる。
				//Math.powを使うとケースによっては値が不正になる。
				if(dist <= (circles[i].r + circles[j].r)*(circles[i].r + circles[j].r) && dist >= (circles[i].r - circles[j].r)*(circles[i].r - circles[j].r) ) {
					dj.union(i, j);
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			long dx = circles[i].x - sx;
			long dy = circles[i].y - sy;
			long dist = dx*dx + dy*dy;
			
			//始点・終点に関しては距離がちょうど半径と一致すること
			if(dist == circles[i].r*circles[i].r) {
				dj.union(i, n);
			}
		}
		
		for(int i = 0; i < n; i++) {
			long dx = circles[i].x - tx;
			long dy = circles[i].y - ty;
			long dist = dx*dx + dy*dy;
			
			if(dist == circles[i].r*circles[i].r) {
				dj.union(i, n + 1);
			}
		}
		
		if(dj.isSameSet(n, n + 1)) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}
}

class Circle {
	long x;
	long y;
	long r;
	
	Circle(long x, long y, long r){
		this.x = x;
		this.y = y;
		this.r = r;
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