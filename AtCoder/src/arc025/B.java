package arc025;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int w = sc.nextInt();

		int[][] c = new int[h][w];

		for(int i = 0; i < h; i++){
			for(int j = 0; j < w; j++){
				c[i][j] = sc.nextInt();
			}
		}

		//(1,1)から(i,j)までの白と黒の合計をあらかじめ求めておく
		//dpで計算可能
		int[][] white = new int[h + 1][w + 1];
		int[][] black = new int[h + 1][w + 1];

		for(int i = 1; i <= h; i++){
			for(int j = 1; j <= w; j++){
				white[i][j] = white[i - 1][j] + white[i][j - 1] - white[i - 1][j - 1];
				black[i][j] = black[i - 1][j] + black[i][j - 1] - black[i - 1][j - 1];

				if((i + j)%2 == 0){
					black[i][j] += c[i - 1][j - 1];
				}
				else {
					white[i][j] += c[i - 1][j - 1];
				}

			}
		}

		//すべての左上座標および高さ、幅についてループを回しても間に合う
		int result = 0;
		for(int i = 0; i < h; i++){
			for(int j = 0; j < w; j++){
				for(int tmpH = 1; i + tmpH <= h; tmpH++){
					for(int tmpW = 1; j + tmpW <= w; tmpW++){
						int blackSum = black[i + tmpH][j + tmpW] - black[i + tmpH][j] - black[i][j + tmpW] + black[i][j];
						int whiteSum = white[i + tmpH][j + tmpW] - white[i + tmpH][j] - white[i][j + tmpW] + white[i][j];

						if(blackSum == whiteSum){
							result = Math.max(result, tmpW*tmpH);
						}
					}
				}
			}
		}

		System.out.println(result);

	}
}
