package arc038;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int w = sc.nextInt();

		char[][] matrix = new char[h + 1][w + 1];

		//右と下に壁を追加しておくと後の処理が楽
		for(int i = 0; i < h + 1; i++){
			Arrays.fill(matrix[i], '#');

			if(i == h){
				break;
			}
			String tmp = sc.next();

			for(int j = 0; j < w; j++){
				matrix[i][j] = tmp.charAt(j);
			}
		}


		//右下から始めれば普通のループでできる
		for(int j = w - 1; j >= 0; j--){
			for(int i = h - 1; i >= 0; i--){
				if(matrix[i][j] == '#'){
					continue;
				}

				//どこにも移動できないマスは負け確マス
				if(matrix[i + 1][j] == '#' && matrix[i][j + 1] == '#' && matrix[i + 1][j + 1] == '#'){
					matrix[i][j] = 'L';
				}

				//移動できるマスに1つでも負け確マスがあるならそこに相手を追い込めるので勝ち確
				else if(matrix[i + 1][j] == 'L' || matrix[i][j + 1] == 'L' || matrix[i + 1][j + 1] == 'L'){
					matrix[i][j] = 'W';
				}

				//移動できるマスのすべてが勝ち確マスなのでここは負け確
				else {
					matrix[i][j] = 'L';
				}
			}
		}

		System.out.println(matrix[0][0] == 'W' ? "First" : "Second");
	}
}