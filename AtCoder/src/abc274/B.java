package abc274;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
 
		int h = sc.nextInt();
		int w = sc.nextInt();
		
		char[][] matrix = new char[h][w];
		
		for(int i = 0; i < h; i++) {
			matrix[i] = sc.next().toCharArray();
		}
		for(int i = 0; i < w; i++) {
			int count = 0;
			
			for(int j = 0; j < h; j++) {
				if(matrix[j][i] == '#') {
					count++;
				}
				
			}
			System.out.print(count + " ");
		}
		System.out.println();
	}
}
 
	