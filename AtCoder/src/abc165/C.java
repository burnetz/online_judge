package abc165;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int q = sc.nextInt();

		array = new int[n];
		//0番目と1番目の比較は存在しないしラストもMとは限らないので
		//1番目は1と決め打ちしていい
		array[0] = 1;
		query = new int[q][4];
		for(int i = 0; i < q; i++){
			for(int j = 0; j < 4; j++){
				query[i][j] = sc.nextInt();
			}
		}

		System.out.println(dfs(1, n, m));
	}

	static int query[][];
	static int array[];

	//入力の制約上相当厳しいと思ったが
	//何故かDFSによる全探索で間に合う。
	static int dfs(int depth, int n, int m){
		if(depth == n){

			return calc();
		}

		int result = 0;
		for(int i = array[depth - 1] ; i <= m; i++){
			array[depth] = i;

			result = Math.max(result, dfs(depth + 1, n, m));
		}

		return result;
	}

	static int calc(){
		int result = 0;
		for(int i = 0; i < query.length; i++){
			if(array[query[i][1] - 1] - array[query[i][0] - 1] == query[i][2]){
				result += query[i][3];
			}
		}

		return result;
	}
}
