package abc224;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int w = sc.nextInt();
		
		int matrix[][] = new int[h][w];
		
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				for(int i2 = i + 1; i2 < h; i2++) {
					for(int j2 = j + 1; j2 < w; j2++) {
						if(matrix[i][j] + matrix[i2][j2] > matrix[i2][j] + matrix[i][j2]) {
							System.out.println("No");
							return;
						}
					}
				}
			}
		}
		
		System.out.println("Yes");
	}
}

