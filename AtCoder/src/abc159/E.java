package abc159;

import java.util.Scanner;

public class E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int w = sc.nextInt();
		int K = sc.nextInt();

		int[][] input = new int[h][w];
		for(int i = 0; i < h; i++){
			String tmp = sc.next();
			for(int j = 0; j < w; j++){
				input[i][j] = tmp.charAt(j) - '0';
			}
		}
		int[][] sumWhite = new int[h + 1][w + 1];

		//下準備。これをやっておくと長方形内の白の数を計算しやすくなる
		for(int i = 1; i <= h; i++){
			for(int j = 1; j <= w; j++){
				sumWhite[i][j] = sumWhite[i - 1][j] + sumWhite[i][j - 1] - sumWhite[i - 1][j - 1];
				if(input[i - 1][j - 1] == 1){
					sumWhite[i][j]++;
				}
			}
		}

		int result = Integer.MAX_VALUE;
loop:		for(int i = 0; i < Math.pow(2, h - 1) ; i++){
			boolean[] horizon = new boolean[h - 1];

			int tmpI = i;
			int cut = 0;
			//水平方向の切り方については全探索が可能
			for(int j = 0; j < h - 1; j++){
				if(tmpI % 2 == 1){
					horizon[j] = true;
					cut++;
				}
				tmpI /= 2;
			}

			int prevVert = 0;

			for(int j = 0; j < w; j++){
				int prevHor = 0;
				for(int k = 0; k < h; k++){
					//最後の行かカット予定位置になったらその地点が含まれる長方形内の白の数を求める
					if(k == h - 1 || horizon[k]){
						int white = sumWhite[k + 1][j + 1] - sumWhite[prevHor][j + 1]
								- sumWhite[k + 1][prevVert] + sumWhite[prevHor][prevVert];
						prevHor = k + 1;
						if(white > K){
							//垂直に切ったばかりなのにオーバーしたので不適
							if(prevVert == j){
								continue loop;
							}
							//オーバーになる列の直前で切る
							else {
								prevVert = j;
								cut++;
								break;
							}
						}
					}
				}
			}
			result = Math.min(result, cut);
		}

		System.out.println(result);

	}

}
