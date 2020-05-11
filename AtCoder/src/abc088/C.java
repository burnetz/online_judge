package abc088;

import java.io.IOException;
import java.util.Scanner;

public class C {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int matrix[][] = new int[3][3];

		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				matrix[i][j] = sc.nextInt();
			}
		}

		for(int j = 0; j < 2; j++){
			for(int i = 1; i < 3; i++){
				if(matrix[i - 1][j] - matrix[i - 1][j + 1] != matrix[i][j] - matrix[i][j + 1]){
					System.out.println("No");
					return;
				}
			}
		}
		for(int i = 0; i < 2; i++){
			for(int j = 1; j < 3; j++){
				if(matrix[i + 1][j - 1] - matrix[i][j - 1] != matrix[i + 1][j] - matrix[i][j]){
					System.out.println("No");
					return;
				}
			}
		}

		System.out.println("Yes");
	}


}
