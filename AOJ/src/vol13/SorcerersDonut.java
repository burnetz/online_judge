package vol13;

import java.util.Arrays;
import java.util.Scanner;

public class SorcerersDonut {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		while(true){
			int h = sc.nextInt();
			int w = sc.nextInt();

			if(h == 0){
				break;
			}

			char[][] input = new char[h][w];

			for(int i = 0; i < h; i++){
				input[i] = sc.next().toCharArray();
			}

			String result = "";
			//mod計算前提で移動パターンを構成しておくと楽
			int dx[] = {0,1,1,1,0,w-1,w-1,w-1};
			int dy[] = {h-1,h-1,0,1,1,1,0,h-1};
			boolean visit1[][] = new boolean[h][w];
			boolean visit2[][] = new boolean[h][w];

			//同じことを普通のStringでやるとMLEになる
			StringBuffer tmpResult;

			//サイズが小さいのでループはかなり強引でも問題ない。
			//ただしMLEにならないための工夫は必要
			for(int i = 0; i < h; i++){
				for(int j = 0; j < w; j++){
					for(int k = 0; k < h; k++){
						for(int l = 0; l < w; l++){
							if(i == k && j == l){
								continue;
							}

							if(input[i][j] != input[k][l]){
								continue;
							}

							if(i*w + j >= k*w + l){
								continue;
							}

							for(int d1 = 0; d1 < 8; d1++){
								for(int d2 = 0; d2 < 8; d2++){
									for(int p = 0; p < h; p++){
										Arrays.fill(visit1[p], false);
										Arrays.fill(visit2[p], false);
									}

									int x1 = j, y1 = i, x2 = l, y2 = k;
									tmpResult = new StringBuffer();
									while(input[y1][x1] == input[y2][x2]){
										tmpResult.append(input[y1][x1]);
										visit1[y1][x1] = true;
										visit2[y2][x2] = true;

										x1 = (x1 + dx[d1])%w;
										y1 = (y1 + dy[d1])%h;
										x2 = (x2 + dx[d2])%w;
										y2 = (y2 + dy[d2])%h;

										if(visit1[y1][x1] || visit2[y2][x2]){
											break;
										}
									}

									if(tmpResult.length() > result.length() ||
											(tmpResult.length() == result.length() && tmpResult.toString().compareTo(result) < 0)){
										result = tmpResult.toString();
									}
								}
							}
						}
					}
				}
			}

			System.out.println(result.length() >= 2 ? result : 0);
		}
	}

}
