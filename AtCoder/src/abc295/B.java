package abc295;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
 
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		char[][] matrix = new char[r][c];
		
		for(int i = 0; i < r; i++) {
			matrix[i] = sc.next().toCharArray();
		}
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(Character.isDigit(matrix[i][j])) {
					for(int k = 0; k < r; k++) {
						for(int l = 0; l < c; l++) {
							int dist = Math.abs(i - k) + Math.abs(j - l);
							int power = matrix[i][j] - '0';
							
							if(dist <= power && matrix[k][l] == '#') {
								matrix[k][l] = '.';
							}
						}
					}
					matrix[i][j] = '.';
				}
			}
		}
		
		for(int i = 0; i < r; i++) {
			System.out.println(matrix[i]);
		}
	}		
}