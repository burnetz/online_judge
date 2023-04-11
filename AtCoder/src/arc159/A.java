package arc159;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		long k = sc.nextLong();

		//あえて4倍の広さで確保する。
		int matrix[][] = new int[n*2][n*2];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				matrix[i][j] = sc.nextInt() == 1 ? 1 : INF;
				matrix[n + i][j] = matrix[i][j];
				matrix[i][n + j] = matrix[i][j];
				matrix[n + i][n + j] = matrix[i][j];
			}
		}

		long[][] dist = warshallFloyd(matrix);
		int q = sc.nextInt();
		
		//グラフが繰り返しである以上は基本的にはmodで考えて良い。
		//ただし余りを求めた結果スタートとゴールが全く同じになると答えが変わるため
		//あえてゴールをnだけずらす。
		//スタートは[0, n), ゴールは[n, 2n)となる。
		for(int i = 0; i < q; i++) {
			int from = (int)((sc.nextLong() - 1)%n);
			int to = (int)((sc.nextLong() - 1)%n + n);
			
			if(dist[from][to] != INF) {
				System.out.println(dist[from][to]);
			}
			else {
				System.out.println(-1);
			}
		}
	}

	static int INF = Integer.MAX_VALUE;
	static long[][] warshallFloyd(int[][] matrix){
		int n = matrix.length;

		long[][] dist = new long[n][n];

		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if(i == j){
					dist[i][j] = 0;
				}
				else {
					dist[i][j] = matrix[i][j];
				}
			}
		}

		for(int k = 0; k < n; k++){
			for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					if(dist[i][k] == INF || dist[k][j] == INF){
						continue;
					}
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}

		return dist;
	}
}