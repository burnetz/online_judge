package arc030;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int x = sc.nextInt() - 1;

		jewel = new int[n];

		for(int i = 0; i < n; i++){
			jewel[i] = sc.nextInt();
		}

		edge = new int[n][n];

		for(int i = 0; i < n - 1; i++){
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;

			edge[a][b] = edge[b][a] = 1;
		}

		visit = new boolean[n];

		//スタート地点に行くための往復も存在するイメージ。
		//ただし宝石が1個もないときは全く行く価値がないので0
		System.out.println(Math.max(0, dfs(x) - 2));
	}

	static int jewel[];
	static int edge[][];
	static boolean visit[];

	static int dfs(int vid){
		visit[vid] = true;

		int result = 0;
		int next = 0;
		for(int i = 0; i < edge.length; i++){
			if(edge[vid][i] == 1 && !visit[i]){
				int tmp = dfs(i);
				next++;

				if(tmp > 0){
					result += tmp;
				}
			}
		}

		//どの頂点についても必ず往復の移動が発生する
		//その先に1つでも宝石があるか、そこに宝石があるなら往復する意味があったということ
		if(result > 0 || jewel[vid] != 0){
			result += 2;
		}

		visit[vid] = false;

		return result;
	}
}
