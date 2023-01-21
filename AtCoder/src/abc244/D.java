package abc244;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		char[][] input = new char[2][3];
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 3; j++) {
				input[i][j] = sc.next().toCharArray()[0];
			}
		}
		
		int notEqual = 0;
		for(int i = 0; i < 3; i++) {
			if(input[0][i] != input[1][i]) {
				notEqual++;
			}
		}
		
		if(notEqual == 2) {
			System.out.println("No");
		}
		else {
			System.out.println("Yes");
		}
	}
}
