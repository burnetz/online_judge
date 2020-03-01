package abc157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class D {

	public static void main(String[] args) throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmpArray = br.readLine().split(" ");
		int n = Integer.parseInt(tmpArray[0]);
		int m = Integer.parseInt(tmpArray[1]);
		int k = Integer.parseInt(tmpArray[2]);

		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] friends = new ArrayList[n];
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] block = new ArrayList[n];

		DisjointSet unionFind = new DisjointSet(n);

		for(int i = 0; i < n; i++){
			friends[i] = new ArrayList<Integer>();
			block[i] = new ArrayList<Integer>();
		}

		for(int i = 0; i < m; i++){
			tmpArray = br.readLine().split(" ");
			int a = Integer.parseInt(tmpArray[0]) - 1;
			int b = Integer.parseInt(tmpArray[1]) - 1;

			friends[a].add(b);
			friends[b].add(a);

			unionFind.union(a, b);
		}

		for(int i = 0; i < k; i++){
			tmpArray = br.readLine().split(" ");
			int c = Integer.parseInt(tmpArray[0]) - 1;
			int d = Integer.parseInt(tmpArray[1]) - 1;

			block[c].add(d);
			block[d].add(c);
		}

		//各グループの人数を数えておく（後で比較的高速に参照可）
		int[] groupMember = new int[n];
		for(int i = 0; i < n; i++){
			groupMember[unionFind.findSet(i)]++;
		}

		for(int i = 0; i < n; i++){
			//直接の友達は間違いなく同じグループなのでそのまま引いて良い
			int count = groupMember[unionFind.findSet(i)] - friends[i].size() - 1;

			int innerBlock = 0;

			Iterator<Integer> it = block[i].iterator();

			//同じグループかつブロックしている人数を数える
			while(it.hasNext()){
				if(unionFind.isSameSet(i, it.next())){
					innerBlock++;
				}
			}

			count -= innerBlock;

			System.out.print(count);
			if(i != n - 1){
				System.out.print(" ");
			}
		}
		System.out.println();
	}

}

class DisjointSet {
	private int n;
	private int[] p;
	private int[] rank;

	public DisjointSet(int n){
		this.n = n;

		p = new int[n + 1];
		rank = new int[n + 1];

		for(int i = 1; i <= n; i++){
			makeSet(i);
		}
	}

	private void makeSet(int x){
		p[x] = x;
		rank[x] = 0;
	}

	public void union(int x, int y){
		link (findSet(x), findSet(y));
	}

	//今回の問題では特別にpublic
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
}