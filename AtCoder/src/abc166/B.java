package abc166;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		int[][] treat = new int[k][n];
		for(int i = 0; i < k; i++){
			int d = sc.nextInt();

			for(int j = 0; j < d; j++){
				treat[i][sc.nextInt() - 1]++;
			}
		}

		int trick = 0;
		for(int i = 0; i < n; i++){
			boolean nothing = true;

			for(int j = 0; j < k; j++){
				if(treat[j][i] > 0){
					nothing = false;
					break;
				}
			}

			if(nothing){
				trick++;
			}
		}

		System.out.println(trick);


	}

}
