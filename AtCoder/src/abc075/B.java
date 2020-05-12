package abc075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmpArray = br.readLine().split(" ");

		int h = Integer.parseInt(tmpArray[0]);
		int w = Integer.parseInt(tmpArray[1]);

		char[][] matrix = new char[h][w];
		int[][] numOfBomb = new int[h][w];

		int[] dx = {0,1,1,1,0,-1,-1,-1};
		int[] dy = {-1,-1,0,1,1,1,0,-1};
		for(int i = 0; i < h; i++){
			String input = br.readLine();
			for(int j = 0; j < w; j++){
				matrix[i][j] = input.charAt(j);

				//八方向に爆弾数加算
				if(matrix[i][j] == '#'){
					for(int k = 0; k < 8; k++){
						int x2 = j + dx[k];
						int y2 = i + dy[k];

						if(inRange(x2, y2, w, h) && matrix[y2][x2] != '#'){
							numOfBomb[y2][x2]++;
						}
					}
				}
			}
		}

		for(int i = 0; i < h; i++){
			for(int j = 0; j < w; j++){
				if(matrix[i][j] == '.'){
					System.out.print(numOfBomb[i][j]);
				}
				else {
					System.out.print(matrix[i][j]);
				}
			}

			System.out.println();
		}

	}

	static boolean inRange(int x, int y, int w, int h){
		if(x < 0 || x >= w || y < 0 || y >= h){
			return false;
		}
		else return true;
	}

}