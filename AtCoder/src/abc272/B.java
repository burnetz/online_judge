package abc272;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
 
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		boolean matrix[][] = new boolean[n][n];

		for(int i = 0; i < m; i++) {
			int k = sc.nextInt();
			
			int tmp[] = new int[k];
			
			for(int j = 0; j < k; j++) {
				tmp[j] = sc.nextInt() - 1;
			}
			
			for(int j = 0; j < k; j++) {
				for(int l = j + 1; l < k; l++) {
					matrix[tmp[j]][tmp[l]] = true;
				}
			}
		}
		
		
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				if(!matrix[i][j]) {
					System.out.println("No");
					return;
				}
			}
		}
		
		System.out.println("Yes");
	}
}
 
	