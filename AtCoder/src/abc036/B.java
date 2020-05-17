package abc036;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		char input[][] = new char[n][n];

		for(int i = 0; i < n; i++){
			String str = sc.next();

			for(int j = 0; j < n; j++){
				input[i][j] = str.charAt(j);
			}
		}

		for(int j = 0; j < n; j++){
			for(int i = n - 1; i >= 0; i--){
				System.out.print(input[i][j]);
			}
			System.out.println();
		}
	}
}