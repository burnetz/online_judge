package vol22;

import java.util.Arrays;
import java.util.Scanner;

public class Ennichi {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int w = sc.nextInt();
		int n = sc.nextInt();

		input = new char[h][w];
		board = new char[h + 1][w + 1];

		for(int i = 0; i < h; i++){
			String tmp = sc.next();

			for(int j = 0; j < w; j++){
				input[i][j] = tmp.charAt(j);
			}
		}

		for(int i = 0; i < h; i++){
			for(int j = 0; j < w - 1; j++){
				initBoard();
				boolean result = solve(j, i, n);

				if(result){
					System.out.println("YES");
					return;
				}
			}
		}

		System.out.println("NO");

	}

	static char[][] input;
	static char[][] board;

	static boolean solve(int x, int y, int n){
		int h = input.length;
		int w = input[0].length;

		//交換フェーズ（1試行あたり1回しか発生しない）
		char tmp = board[y][x];
		board[y][x] = board[y][x + 1];
		board[y][x + 1] = tmp;


		while(true){
			boolean change = false;
			//落下フェーズ
			for(int j = 0; j < w; j++){
				for(int i = 1; i < h; i++){
					if(board[i][j] != '.' && board[i - 1][j] == '.'){
						change = true;
						for(int k = i - 1; k >= 0; k--){
							if(k == 0 || board[k - 1][j] != '.'){
								board[k][j] = board[i][j];
								board[i][j] = '.';
								break;
							}
						}
					}
				}
			}

			boolean delete[][] = new boolean[h][w];

			//横方向削除調査フェーズ（フラグのみ。本当に消すと縦方向のときにバグる）
			for(int i = 0; i < h; i++){
				int count = 0;
				for(int j = 0; j <= w; j++){
					if(j == 0 || board[i][j] != board[i][j - 1]){
						if(count >= n){
							for(int k = j - 1; k >= j - count; k--){
								delete[i][k] = true;
							}
						}
						count = 1;
					}
					else {
						count++;
					}
				}
			}

			//縦方向削除調査フェーズ
			for(int j = 0; j < w; j++){
				int count = 0;
				for(int i = 0; i <= h; i++){
					if(i == 0 || board[i][j] != board[i - 1][j]){
						if(count >= n){
							for(int k = i - 1; k >= i - count; k--){
								delete[k][j] = true;
							}
						}
						count = 1;
					}
					else {
						count++;
					}
				}
			}

			//削除フェーズおよび全消し確認
			boolean allDeleted = true;
			for(int i = 0; i < h; i++){
				for(int j = 0; j < w; j++){
					if(delete[i][j] && board[i][j] != '.'){
						change = true;
						board[i][j] = '.';
					}

					if(board[i][j] != '.'){
						allDeleted = false;
					}
				}
			}

			if(allDeleted){
				return true;
			}

			//全消ししておらずかつ変化もないならこの後何も起きず失敗確定
			if(!change){
				break;
			}
		}

		return false;
	}

	static void initBoard(){
		for(int i = 0; i < input.length; i++){
			Arrays.fill(board[i], '.');

			for(int j = 0; j < input[i].length; j++){
				board[i][j] = input[input.length - i - 1][j];
			}
		}

	}

	static void initDeleteFlag(boolean[][] delete){
		for(int i = 0; i < delete.length; i++){
			Arrays.fill(delete[i], false);
		}
	}

	static void printBoard(){
		int h = input.length;
		int w = input[0].length;

		for(int i = h - 1; i >= 0; i--){
			for(int j = 0; j < w; j++){
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

}
