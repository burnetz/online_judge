package vol12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakeSequence {
	static final int NONE = 0;
	static final int BLACK = 1;
	static final int WHITE = 2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true){
			String[] tmpArray = br.readLine().split(" ");

			int n = Integer.parseInt(tmpArray[0]);
			int m = Integer.parseInt(tmpArray[1]);
			int p = Integer.parseInt(tmpArray[2]);

			if(n == 0){
				break;
			}

			int input[][] = new int[p][2];
			for(int i = 0; i < p; i++){
				tmpArray = br.readLine().split(" ");

				int x = Integer.parseInt(tmpArray[0]);
				int y = Integer.parseInt(tmpArray[1]);

				input[i][0] = x;
				input[i][1] = y;
			}

			//少し大きめに作るときっと探索しやすい
			int space[][][] = new int[n + 2][n + 2][n + 2];

			for(int i = 0; i < p; i++){
				int player;
				if(i % 2 == 0){
					player = BLACK;
				}
				else {
					player = WHITE;
				}
				int len = put(space, input[i][0], input[i][1], player);

				if(len >= m){
					if(player == BLACK){
						System.out.print("Black ");
					}
					else {
						System.out.print("White ");
					}
					System.out.println(i + 1);

					break;
				}
				else if(i == p - 1){
					System.out.println("Draw");
				}
			}
		}
	}

	//探索用ベクトル
	static int vecX[] = {1,0,0,   1, 1, 0, 0, 1, 1,    1, 1, 1, 1};
	static int vecY[] = {0,1,0,   1,-1, 1, 1, 0, 0,    1, 1,-1,-1};
	static int vecZ[] = {0,0,1,   0, 0, 1,-1, 1,-1,    1,-1, 1,-1};

	//return 置いたボールを含む列の中で最長のものの長さ
	static int put(int[][][] space, int x, int y, int player){
		int result = 0;
		//置ける高さを探す
		for(int i = 1; i < space.length; i++){
			if(space[x][y][i] == NONE){
				space[x][y][i] = player;

				//各方向にいくつ連続しているかを調べる
				for(int j = 0; j < vecX.length; j++){
					int tmpLen = 1;

					//順方向
					int k = 1;
					while(space[x + k*vecX[j]][y + k*vecY[j]][i + k*vecZ[j]] == player){
						tmpLen++;
						k++;
					}
					//逆方向
					k = 1;
					while(space[x - k*vecX[j]][y - k*vecY[j]][i - k*vecZ[j]] == player){
						tmpLen++;
						k++;
					}
					result = Math.max(result, tmpLen);
				}

				break;
			}
		}

		return result;
	}
}
