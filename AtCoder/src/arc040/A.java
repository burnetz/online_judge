package arc040;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		int r = 0;
		int b = 0;
		
		for(int i = 0; i < n; i++) {
			char[] str = sc.next().toCharArray();
			
			for(int j = 0; j < n; j++) {
				char c = str[j];
				
				if(c == 'R') {
					r++;
				}
				else if(c == 'B') {
					b++;
				}
			}
		}
		
		if(r > b) {
			System.out.println("TAKAHASHI");
		}
		else if(r < b) {
			System.out.println("AOKI");
		}
		else {
			System.out.println("DRAW");
		}
	}
}

