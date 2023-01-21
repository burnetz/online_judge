package codeformula2014quala;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int pin[] = new int[10];

		for(int i = 0; i < a; i++) {
			int tmp = sc.nextInt();
			if(tmp == 0) {
				tmp = 9;
			}
			else {
				tmp--;
			}
			pin[tmp] = 1;
		}
		
		for(int i = 0; i < b; i++) {
			int tmp = sc.nextInt();
			if(tmp == 0) {
				tmp = 9;
			}
			else {
				tmp--;
			}
			pin[tmp] = 2;
		}
		
		for(int i = 0; i < 4; i++) {
			int start[] = {6,3,1,0};
			
			for(int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for(int j = 0; j < 4 - i; j++) {
				char c;
				switch (pin[start[i] + j]) {
				case 1:
					c = '.';
					break;
				case 2:
					c = 'o';
					break;
				default:
					c = 'x';	
				}
				System.out.print(c+ " ");
			}
			System.out.println();
		}
	}

}
