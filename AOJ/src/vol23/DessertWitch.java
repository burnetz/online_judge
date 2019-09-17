package vol23;

import java.util.Arrays;
import java.util.Scanner;

public class DessertWitch {

	static final int W = 8;
	static final int H = 8;
	static char[][] board = new char[W + 2][H + 2];

	static int[] vx = {0,1,1,1,0,-1,-1,-1};
	static int[] vy = {1,1,0,-1,-1,-1,0,1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for(int i = 0; i < board.length; i++){
			Arrays.fill(board[i], '.');
		}

		for(int i = 1; i <= H; i++){
			String str = sc.next();

			for(int j = 1; j <= W; j++){
				board[i][j] = str.charAt(j - 1);
			}
		}

		Player[] players = new Player[2];

		players[0] = new Player('o', 'x');
		players[1] = new Player('x', 'o');

		int pid = 0;

		while(true){
			Player current = players[pid%players.length];

			int tmpMax = 0;
			int maxX = 0;
			int maxY = 0;

			//最適な場所を探す
			for(int i = 1; i <= H; i++){
				for(int j = 1; j <= W; j++){
					if(board[i][j] != '.'){
						continue;
					}
					int tmpCount = countReversible(current, j, i);

					//player1とplayer2では戦略が若干異なる
					if((pid%players.length == 0 &&  tmpMax < tmpCount) ||
							pid%players.length == 1 && tmpMax <= tmpCount){
						tmpMax = tmpCount;
						maxX = j;
						maxY = i;
					}
				}
			}

			//良い場所があったならそこに配置した上で敵のクッキーをひっくり返す
			if(tmpMax != 0){
				reverse(current, maxX, maxY);
				current.put = true;
			}
			//置ける場所がない場合は置けなかったということを記録する
			else {
				current.put = false;
			}
			pid++;

			//両者とも置けないなら終了
			if(!players[0].put && !players[1].put){
				break;
			}
		}

		printBoard();
	}

	//盤面出力用
	static void printBoard (){
		for(int i = 1; i <= H; i++){
			for(int j = 1; j <= W; j++){
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

	//x,yにクッキーを配置した際に裏返すことができる枚数を数える
	static int countReversible(Player player, int x, int y){
		int count = 0;

		for(int i = 0; i < 8; i++){
			//大前提として最低1枚はその方向に敵のクッキーが必要
			if(board[y + vy[i]][x + vx[i]] == player.enemy){
				int j = 1;
				while(board[y + vy[i]*j][x + vx[i]*j] != '.'){
					if(board[y + vy[i]*j][x + vx[i]*j] == player.piece){
						count += j - 1;
						break;
					}

					j++;
				}
			}
		}

		return count;
	}

	//x,yにクッキーを配置した上で周囲を裏返す
	static void reverse(Player player, int x, int y){
		board[y][x] = player.piece;
		for(int i = 0; i < 8; i++){
			//その方向で裏返すことが可能か判定
			boolean reversible = false;
			if(board[y + vy[i]][x + vx[i]] == player.enemy){
				int j = 1;
				while(board[y + vy[i]*j][x + vx[i]*j] != '.'){
					if(board[y + vy[i]*j][x + vx[i]*j] == player.piece){
						reversible = true;
						break;
					}

					j++;
				}
			}

			//実際に裏返す処理
			if(reversible){
				int j = 1;
				while(board[y + vy[i]*j][x + vx[i]*j] == player.enemy){
					board[y + vy[i]*j][x + vx[i]*j] = player.piece;
					j++;
				}
			}
		}
	}

}

class Player {
	char piece;
	char enemy;
	boolean put = true;

	Player(char piece, char enemy){
		this.piece = piece;
		this.enemy = enemy;
	}
}