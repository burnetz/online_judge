package abc241;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		char[][] matrix = new char[n][n];
		
		for(int i = 0; i < n; i++) {
			matrix[i] = sc.next().toCharArray();
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(n - j >= 6) {
					int count = 0;
					
					for(int k = 0; k < 6; k++) {
						if(matrix[i][j + k] == '#') {
							count++;
						}
					}
					
					if(count >= 4) {
						System.out.println("Yes");
						return;
					}
				}
				if(n - i >= 6) {
					int count = 0;
					
					for(int k = 0; k < 6; k++) {
						if(matrix[i + k][j] == '#') {
							count++;
						}
					}
					
					if(count >= 4) {
						System.out.println("Yes");
						return;
					}
				}
				
				if(i >= 5 && n - j >= 6) {
					int count = 0;
					
					for(int k = 0; k < 6; k++) {
						if(matrix[i - k][j + k] == '#') {
							count++;
						}
					}
					
					if(count >= 4) {
						System.out.println("Yes");
						return;
					}
				}
				
				if(n - i >= 6 && n - j >= 6) {
					int count = 0;
					
					for(int k = 0; k < 6; k++) {
						if(matrix[i + k][j + k] == '#') {
							count++;
						}
					}
					
					if(count >= 4) {
						System.out.println("Yes");
						return;
					}
				}
			}
		}
		
		System.out.println("No");
	}
}