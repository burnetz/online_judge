package abc269;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
 
		char input[][] = new char[10][10];
		
		for(int i = 0; i < 10; i++) {
			input[i] = sc.next().toCharArray();
		}
		
		int left = -1;
		int right = -1;
		int top = -1;
		int bottom = -1;
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(input[i][j] == '#') {
					right = j;
					bottom = i;
					
					if(left == -1) {
						left = j;
					}
					
					if(top == -1) {
						top = i;
					}
				}
			}
		}
		
		System.out.println((top + 1) + " " + (bottom + 1));
		System.out.println((left + 1) + " " + (right + 1));
		
	}
}
 
	