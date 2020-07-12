package agc038;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int w = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();

		int board[][] = new int[h][w];

		//問題ページの実行例は罠
		//110
		//110
		//001みたいな形式にすれば必ず作ることができる
		for(int i = 0; i < h - b; i++){
			for(int j = 0; j < w - a; j++){
				board[i][j] = 1;
			}
		}

		for(int i = h - b; i < h; i++){
			for(int j = w - a; j < w; j++){
				board[i][j] = 1;
			}
		}

		for(int i = 0; i < h; i++){
			for(int j = 0; j < w; j++){
				System.out.print(board[i][j]);
			}
			System.out.println();
		}

	}

}
