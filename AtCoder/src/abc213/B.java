package abc213;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		Player a[] = new Player[n];
		for(int i = 0; i < n; i++){
			a[i] = new Player(i + 1, sc.nextInt());
		}

		Arrays.sort(a);
		System.out.println(a[1].id);
	}
}

class Player implements Comparable<Player>{
	int id;
	int point;

	Player(int id, int point){
		this.id = id;
		this.point = point;
	}

	@Override
	public int compareTo(Player p) {
		// TODO 自動生成されたメソッド・スタブ
		return p.point - this.point;
	}
}