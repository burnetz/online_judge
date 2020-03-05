package abc129;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {

	public static void main(String[] args) throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmpArray = br.readLine().split(" ");
		int h = Integer.parseInt(tmpArray[0]);
		int w = Integer.parseInt(tmpArray[1]);

		char[][] board = new char[h][w];

		DisjointSet ufVertical = new DisjointSet(h*w);
		DisjointSet ufHorizontal = new DisjointSet(h*w);


		for(int i = 0; i < h; i++){
			board[i] = br.readLine().toCharArray();
		}

		for(int i = 0; i < h; i++){
			for(int j = 0; j < w; j++){
				if(board[i][j] == '#'){
					continue;
				}
				//縦に連続しているなら同じグループ
				if(i >= 1 && board[i][j] == board[i - 1][j]){
					ufVertical.union(i*w + j, (i - 1)*w + j);
				}
				//横に連続しているなら同じグループ
				if(j >= 1 && board[i][j] == board[i][j - 1]){
					ufHorizontal.union(i*w + j, i*w + j - 1);
				}
			}
		}

		//各グループの数を数えておく（後で比較的高速に参照可）
		int[] groupCountV = new int[h*w];
		int[] groupCountH = new int[h*w];
		for(int i = 0; i < h*w; i++){
			groupCountV[ufVertical.findSet(i)]++;
			groupCountH[ufHorizontal.findSet(i)]++;

		}

		int result = 0;
		for(int i = 0; i < h; i++){
			for(int j = 0; j < w; j++){
				if(board[i][j] == '#'){
					continue;
				}

				//縦に連続しているマスの数 + 横に連続しているマスの数 - 1の最大値が答え
				//愚直にループを回すとO(H^2 W^2)だがfindSetは十分に速い
				int tmp = groupCountV[ufVertical.findSet(i*w + j)] + groupCountH[ufHorizontal.findSet(i*w + j)] - 1;

				result = Math.max(tmp, result);
			}

		}

		System.out.println(result);
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