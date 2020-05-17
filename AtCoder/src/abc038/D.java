package abc038;

import java.util.Arrays;
import java.util.Scanner;

public class D {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int w = sc.nextInt();

		char input[][] = new char[h][w];

		for(int i = 0; i < h; i++){
			String str = sc.next();
			for(int j = 0; j < w; j++){
				input[i][j] = str.charAt(j);
			}
		}

		int dx[] = {0,1,1,1,0,-1,-1,-1};
		int dy[] = {-1,-1,0,1,1,1,0,-1};
		//圧縮画像で白いピクセルがあったならそこと周囲は確実に白じゃないとまずい
		boolean exactlyWhite[][] = new boolean[h][w];
		for(int i = 0; i < h; i++){
			for(int j = 0; j < w; j++){
				if(input[i][j] == '.'){
					exactlyWhite[i][j] = true;

					for(int k = 0; k < 8; k++){
						int tmpX = j + dx[k];
						int tmpY = i + dy[k];

						if(tmpX >= 0 && tmpX < w && tmpY >= 0 && tmpY < h){
							exactlyWhite[tmpY][tmpX] = true;
						}
					}
				}
			}
		}

		char[][] result = new char[h][w];

		//圧縮ファイルで黒にもかかわらずそのマスと周囲を1箇所も塗れないなら矛盾
		//それ以外なら1箇所以上どこか適当に塗ればOK（今回は塗れる場所は全部塗っている）
		for(int i = 0; i < h; i++){
			Arrays.fill(result[i], '.');
			for(int j = 0; j < w; j++){
				if(input[i][j] == '#'){
					int count = 0;

					if(!exactlyWhite[i][j]){
						result[i][j] = '#';
						count++;
					}

					for(int k = 0; k < 8; k++){
						int tmpX = j + dx[k];
						int tmpY = i + dy[k];

						if(tmpX >= 0 && tmpX < w && tmpY >= 0 && tmpY < h && !exactlyWhite[tmpY][tmpX]){
							result[tmpY][tmpX] = '#';
							count++;
						}
					}

					if(count == 0){
						System.out.println("impossible");
						return;
					}
				}
			}
		}

		System.out.println("possible");

		for(int i = 0; i < h; i++){
			System.out.println(result[i]);
		}
	}
}