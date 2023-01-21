package abc277;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		//1階から到達可能であるかはunion-findで確認できる。
		//ただし入力の範囲が広すぎるので座標圧縮を使って2n程度の領域で済むようにする。
		DisjointSet set = new DisjointSet(2*n + 1);
		
		int a[] = new int[n];
		int b[] = new int[n];
		
		//座標圧縮用のmap
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		//1階は必ず行ける。0をマッピングしておくと以降の追加が楽。
		map.put(1, 0);
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
			
			if(!map.containsKey(a[i])) {
				map.put(a[i], map.size());
			}
			if(!map.containsKey(b[i])) {
				map.put(b[i], map.size());
			}
		}
		
		for(int i = 0; i < n; i++) {
			int tmpA = map.get(a[i]);
			int tmpB = map.get(b[i]);
			
			set.union(tmpA, tmpB);
		}
		
		int result = 1;
		for(int i = 0; i < n; i++) {
			int tmpA = map.get(a[i]);
			int tmpB = map.get(b[i]);
			
			if(set.isSameSet(0, tmpA)) {
				result = Math.max(result, a[i]);
			}

			if(set.isSameSet(0, tmpB)) {
				result = Math.max(result, b[i]);
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
