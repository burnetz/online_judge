package abc232;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int w = sc.nextInt();
		
		char[][] matrix = new char[h][w];
		
		for(int i = 0; i < h; i++) {
			matrix[i] = sc.next().toCharArray();
		}
		
		int steps[][] = new int[h][w];
		steps[0][0] = 1;
		int result = 1;
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				if(matrix[i][j] == '#') {
					continue;
				}
				if(i != 0 && matrix[i - 1][j] == '.' && steps[i - 1][j] > 0) {
					steps[i][j] = steps[i - 1][j] + 1;
				}
				if(j != 0 && matrix[i][j - 1] == '.' && steps[i][j - 1] > 0) {
					steps[i][j] = Math.max(steps[i][j], steps[i][j - 1] + 1);
				}
				
				result = Math.max(result, steps[i][j]);
			}
		}
		
		System.out.println(result);
	}

}
