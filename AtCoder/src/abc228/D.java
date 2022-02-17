package abc228;

import java.util.Arrays;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		int n = 1048576;
		
		//各区間をグループとして管理するためのunion-find
		DisjointSet dj = new DisjointSet(n);
		
		//値が代入済みの区間を管理する（長さ1の場合も含む）
		//結合する際には代表する区間だけでも確実に更新されるようにする
		Segment array[] = new Segment[n];
		long data[] = new long[n];
		Arrays.fill(data, -1);
		
		for(int i = 0; i < n; i++) {
			array[i] = new Segment(i + 1);
		}
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < q; i++) {
			int t = sc.nextInt();
			long x = sc.nextLong();
			
			int index = (int)(x%n);
			if(t == 1) {
				int insert;
				//普通に代入してよい場合
				if(data[index] == -1) {
					insert = index;
				}
				else {
					//値があったらその区間の末尾に代入する
					insert = array[dj.findSet(index)].end;
					
					//区間の末尾が最後尾だった場合は先頭を参照
					if(insert == n) {
						
						if(data[0] == -1) {
							insert = 0;
						}
						else {
							insert = array[dj.findSet(0)].end;
						}
					}
				}
				data[insert] = x;
				
				//right union
				if(insert < n - 1 && data[insert + 1] != -1) {
					Segment next = array[dj.findSet(insert + 1)];
					Segment current = array[dj.findSet(insert)];
					
					current.end = next.end;
					
					dj.union(insert, insert + 1);
				}
				//left union
				if(insert > 0 && data[insert - 1] != -1) {
					Segment prev = array[dj.findSet(insert - 1)];
					Segment current = array[dj.findSet(insert)];
					
					prev.end = current.end;
					
					dj.union(insert, insert - 1);
				}
				
			}
			else {
				sb.append(data[index] + "\n");
			}
		}
		
		System.out.print(sb);
	}

}

class Segment {
	int end;
	
	Segment(int end){
		this.end = end;
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
		for(int i = 1039018; i <= 1039089; i++) {
			System.out.print(p[i]+" ");
		}
		System.out.println();
	}
}