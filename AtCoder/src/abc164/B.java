package abc164;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);


		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();

		int turn = 0;
		while(a > 0 && c > 0){
			if(turn % 2 == 0){
				c -= b;
			}
			else {
				a -= d;
			}

			turn++;
		}

		System.out.println(turn % 2 == 1 ? "Yes" : "No");

	}

}
