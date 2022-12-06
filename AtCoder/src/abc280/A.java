package abc280;

import java.util.HashSet;
import java.util.Scanner;

public class A {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int h = sc.nextInt();
		int w = sc.nextInt();
		
		char[][] matrix = new char[h][w];

		for(int i = 0; i < h; i++) {
			matrix[i] = sc.next().toCharArray();
		}
		
		int count = 0;
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				if(matrix[i][j] == '#') {
					count++;
				}
			}
		}
		
		System.out.println(count);
	}
}