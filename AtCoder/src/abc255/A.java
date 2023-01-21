package abc255;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int r = sc.nextInt() - 1;
		int c = sc.nextInt() - 1;
		
		int a[][] = new int[2][2];
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 2; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		System.out.println(a[r][c]);
	}		
}

