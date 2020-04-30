package abc118;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		boolean fav[][] = new boolean[n][m];

		for(int i = 0; i < n; i++){
			int k = sc.nextInt();

			for(int j = 0; j < k; j++){
				fav[i][sc.nextInt() - 1] = true;
			}
		}

		int count = 0;

loop:		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(!fav[j][i]){
					continue loop;
				}
			}

			count++;
		}

		System.out.println(count);
	}

}
