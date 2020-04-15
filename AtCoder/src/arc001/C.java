package arc001;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		int fixedIndex = 0;
		for(int i = 0; i < 8; i++){
			String str = sc.next();
			for(int j = 0; j < 8; j++){
				if(str.charAt(j) == 'Q'){
					fixed[fixedIndex][0] = i;
					fixed[fixedIndex][1] = j;
					fixedIndex++;
				}
			}
		}

		dfs(0);

		System.out.println("No Answer");

	}

	static int fixed[][] = new int[3][2];
	static boolean[] row = new boolean[8];
	static boolean[] pos = new boolean[15];
	static boolean[] neg = new boolean[15];
	static boolean board[][] = new boolean[8][8];

	//8クイーンなので現実的にあり得るパターンを全部当たっても間に合う
	static void dfs(int depth){
		if(depth == 8){
			//初期位置にあるべきクイーンがなければ不適
			for(int i = 0; i < 3; i++){
				if(!board[fixed[i][0]][fixed[i][1]] ){
					return;
				}
			}

			for(int i = 0; i < 8; i++){
				for(int j = 0; j < 8; j++){
					if(board[i][j]){
						System.out.print("Q");
					}
					else {
						System.out.print(".");
					}
				}
				System.out.println();
			}
			//今回は1パターンでも適切な盤面があれば即終了
			System.exit(0);
		}

		for(int i = 0; i < 8; i++){
			if(row[i] || pos[i + depth] || neg[7 - i + depth]){
				continue;
			}
			row[i] = true;
			pos[i + depth] = true;
			neg[7 - i + depth] = true;
			board[i][depth] = true;

			dfs(depth + 1);

			row[i] = false;
			pos[i + depth] = false;
			neg[7 - i + depth] = false;
			board[i][depth] = false;
		}
	}

}
