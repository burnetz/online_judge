package abc099;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		String[] tmpArray = br.readLine().split(" ");

		int n = Integer.parseInt(tmpArray[0]);
		int c = Integer.parseInt(tmpArray[1]);

		int[][] d = new int[c][c];

		for(int i = 0; i < c; i++){
			tmpArray = br.readLine().split(" ");
			for(int j = 0; j < c; j++){
				d[i][j] = Integer.parseInt(tmpArray[j]);
			}
		}

		int[][] matrix = new int[n][n];

		int[][] cost = new int[3][c];
		for(int i = 0; i < n; i++){
			tmpArray = br.readLine().split(" ");
			for(int j = 0; j < n; j++){
				matrix[i][j] = Integer.parseInt(tmpArray[j]);

				//色変更コスト初期化
				for(int k = 0; k < c; k++){
					cost[(i+j)%3][k] += d[matrix[i][j] - 1][k];
				}
			}
		}

		//worst
		int result = Integer.MAX_VALUE;
		for(int i = 0; i < c; i++){
			for(int j = 0; j < c; j++){
				if(i == j){
					continue;
				}
				for(int k = 0; k < c; k++){
					if(i == k || j == k){
						continue;
					}

					int tmpResult = cost[0][i] + cost[1][j] + cost[2][k];

					result = Math.min(result, tmpResult);
				}
			}
		}

		System.out.println(result);
	}

}