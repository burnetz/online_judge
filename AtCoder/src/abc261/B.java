package abc261;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		char[][] input = new char[n][n];
		
		for(int i = 0; i < n; i++) {
			input[i] = sc.next().toCharArray();
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				if((input[i][j] == 'W' && input[j][i] != 'L') || 
						(input[i][j] == 'L' && input[j][i] != 'W' ) ||
						(input[i][j] == 'D' && input[j][i] != 'D')){
					System.out.println("incorrect");
					return;
				}
			}
		}
		
		System.out.println("correct");
	}
}

	
