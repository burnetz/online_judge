package abc251;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		char[] white = new char[b];
		char[] black = new char[b];
		
		for(int i = 0; i < b; i++) {
			white[i] = '.';
			black[i] = '#';
		}
		
		for(int i = 0; i < n*a; i++) {
			for(int j = 0; j < n; j++) {
				if((i/a + j)%2 == 0) {
					System.out.print(white);
				}
				else {
					System.out.print(black);
				}
			}
			System.out.println();
		}
	}
}