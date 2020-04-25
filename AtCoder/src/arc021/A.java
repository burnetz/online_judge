package arc021;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int a[][] = new int[4][4];

		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4; j++){
				a[i][j] = sc.nextInt();
			}
		}

		boolean alive = false;
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4; j++){
				if((j >= 1 && a[i][j] == a[i][j - 1]) || (i >= 1 && a[i][j] == a[i - 1][j])){
					alive = true;
					System.out.println("CONTINUE");
					return;
				}
			}
		}

		System.out.println("GAMEOVER");
	}
}
