package abc262;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		boolean matrix[][] = new boolean[n][n];
		
		for(int i = 0; i < m; i++) {
			int u = sc.nextInt() - 1;
			int v = sc.nextInt() - 1;
			
			matrix[u][v] = true;
			matrix[v][u] = true;
		}
		
		int count = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				for(int k = j + 1; k < n; k++) {
					if(matrix[i][j] && matrix[j][k] && matrix[i][k]) {
						count++;
					}
				}
			}
		}
		
		System.out.println(count);
	}
}

	
