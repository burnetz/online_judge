package abc096;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmpArray = br.readLine().split(" ");

		int h = Integer.parseInt(tmpArray[0]);
		int w = Integer.parseInt(tmpArray[1]);

		char[][] input = new char[h][w];
		char[][] canvas = new char[h][w];

		for(int i = 0; i < h; i++){
			String str = br.readLine();

			for(int j = 0; j < w; j++){
				input[i][j] = str.charAt(j);
				canvas[i][j] = '.';
			}
		}


		//各マスについて探索
		for(int i = 0; i < h; i++){
			for(int j = 0; j < w; j++){
				if(input[i][j] == '.'){
					continue;
				}

				int dx[] = {1,0,-1,0};
				int dy[] = {0,1,0,-1};

				//四方向チェック
				int dirCount = 0;
				for(int k = 0; k < 4; k++){
					if(inRange(j + dx[k], i + dy[k], h, w) &&
							input[i + dy[k]][j + dx[k]] == '#'){
						dirCount++;
					}
				}

				if(dirCount >= 1){
					canvas[i][j] = '#';
					for(int k = 0; k < 4; k++){
						if(inRange(j + dx[k], i + dy[k], h, w) && input[i + dy[k]][j + dx[k]] == '#'){
							canvas[i + dy[k]][j + dx[k]] = '#';
						}
					}

				}
			}
		}

		//同じように書けたかチェック
		for(int i = 0; i < h; i++){
			for(int j = 0; j < w; j++){
				if(input[i][j] != canvas[i][j]){
					System.out.println("No");
					return;
				}
			}
		}

		System.out.println("Yes");
	}

	static boolean inRange(int x, int y, int h, int w){
		if(x >= 0 && x < w && y >= 0 && y < h){
			return true;
		}
		else {
			return false;
		}
	}


}
