package abc012;

import java.util.Arrays;
import java.util.Scanner;

public class D {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int matrix[][] = new int[n][n];

		for(int i = 0; i < n; i++){
			Arrays.fill(matrix[i], INF);
		}
		for(int i = 0; i < m ; i++){
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			int t = sc.nextInt();

			matrix[a][b] = t;
			matrix[b][a] = t;
		}

		//バス停が少ないのでワーシャルフロイトで間に合う
		long result[][] = warshallFloyd(matrix);

		long ans = INF;
		for(int i = 0; i < n; i++){
			long tmpMax = 0;
			for(int j = 0; j < n; j++){
				tmpMax = Math.max(tmpMax, result[i][j]);
			}
			ans = Math.min(ans, tmpMax);
		}

		System.out.println(ans);
	}
	static final int INF = Integer.MAX_VALUE;


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

