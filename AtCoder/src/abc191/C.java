package abc191;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int w = sc.nextInt();

		char[][] matrix = new char[h][w];

		for(int i = 0; i < h; i++){
			matrix[i] = sc.next().toCharArray();
		}

		int result = 0;
		int dx[] = {0,1,1,0};
		int dy[] = {0,0,1,1};

		//マスそのものよりも間の点が角に相応しいかチェックするほうが楽
		for(int i = 0; i < h - 1; i++){
			for(int j = 0; j < w - 1; j++){
				int black = 0;

				for(int k = 0; k < 4; k++){
					if(matrix[i + dy[k]][j + dx[k]] == '#'){
						black++;
					}
				}

				switch(black){
				//点の周辺が1マスまたは3マス塗られているならその点が角になる。
				case 1:
				case 3:
					result++;;
					break;
				//4マス塗られていたり全く塗られていないときはもちろん
				//今回の問題では制約上「斜めに2マス」という塗り方がありえないので
				//1,3マス塗る以外のパターンでは角が増えない。
				default:
					break;
				}
			}

		}

		System.out.println(result);

	}

}
