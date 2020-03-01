package abc157;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		int board[][] = new int[3][3];

		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				board[i][j] = sc.nextInt();
			}
		}
		int n = sc.nextInt();

		for(int k = 0; k < n; k++){
			int tmp = sc.nextInt();

			for(int i = 0; i < 3; i++){
				for(int j = 0; j < 3; j++){
					if(board[i][j] == tmp){
						board[i][j] = 0;
					}
				}
			}
		}

		for(int i = 0; i < 3; i++){
			if(board[i][0] + board[i][1] + board[i][2] == 0){
				System.out.println("Yes");
				return;
			}
			if(board[0][i] + board[1][i] + board[2][i] == 0){
				System.out.println("Yes");
				return;
			}
		}

		if(board[0][0] + board[1][1] + board[2][2] == 0 || board[2][0] + board[1][1] + board[0][2] == 0){
			System.out.println("Yes");
			return;
		}
		System.out.println("No");
	}

}
