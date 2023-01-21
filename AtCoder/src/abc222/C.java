package abc222;

import java.util.Arrays;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		Player[] players = new Player[2*n];
		for(int i = 0; i < 2*n; i++){
			players[i] = new Player(i + 1, sc.next().toCharArray());
		}

		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				char c1 = players[j*2].command[i];
				char c2 = players[j*2 + 1].command[i];

				if((c1 == 'G' && c2 == 'C') || (c1 == 'C' && c2 == 'P') || (c1 == 'P' && c2 == 'G') ){
					players[j*2].win++;
				}
				else if((c1 == 'G' && c2 == 'P') || (c1 == 'C' && c2 == 'G') || (c1 == 'P' && c2 == 'C') ){
					players[j*2 + 1].win++;
				}
			}

			Arrays.sort(players);

//			for(int j = 0; j < 2*n ; j++){
//				System.out.println(players[j].id +" " + players[j].win);
//			}
//			System.out.println();
		}

		for(int i = 0; i < 2*n ; i++){
			System.out.println(players[i].id);
		}
	}
}

class Player implements Comparable<Player>{
	int id;
	int win = 0;
	char[] command;

	Player(int id, char[] command){
		this.id = id;
		this.command = command;
	}

	@Override
	public int compareTo(Player p) {
		// TODO 自動生成されたメソッド・スタブ
		return this.win == p.win ? this.id - p.id :  -this.win + p.win;
	}


}