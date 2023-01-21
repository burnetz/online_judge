package abc237;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int w = sc.nextInt();

		int[][] matrix = new int[h][w];
		
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < w; i++) {
			for(int j = 0; j < h; j++) {
				System.out.print(matrix[j][i]);
				if(j != h - 1) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
		System.out.println();
	}
}

