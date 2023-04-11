package abc297;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int w = sc.nextInt();
		
		char[][] matrix = new char[h][w];
		
		for(int i = 0; i < h; i++) {
			matrix[i] = sc.next().toCharArray();
			
			for(int j = 0; j < w - 1; j++) {
				if(matrix[i][j] == 'T' && matrix[i][j + 1] == 'T') {
					matrix[i][j] = 'P';
					matrix[i][j + 1] = 'C';
				}
			}
			System.out.println(matrix[i]);
		}
		
		
	}
}