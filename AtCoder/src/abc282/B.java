package abc282;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
 
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		char[][] matrix = new char[n][m];
		
		for(int i = 0; i < n; i++) {
			matrix[i] = sc.next().toCharArray();
		}
		
		int result = 0;
		
		for(int i = 0; i < n; i++) {
loop:			for(int j = i + 1; j < n; j++) {
				for(int k = 0; k < m ; k++) {
					if(matrix[i][k] == 'x' && matrix[j][k] == 'x') {
						continue loop;
					}
				}
				result++;
			}
		}
		
		System.out.println(result);
	}
}
