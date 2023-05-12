package abc299;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
 
		int n = sc.nextInt();
		int t = sc.nextInt();
		
		int[] c = new int[n];
		int[] r = new int[n];
		
		for(int i = 0; i < n; i++) {
			c[i] = sc.nextInt();
		}
		
		for(int i = 0; i < n; i++) {
			r[i] = sc.nextInt();
		}
		
		int winner = -1;
		for(int i = 0; i < n; i++) {
			if(c[i] == t) {
				if(winner < 0 || r[winner] < r[i]) {
					winner = i;
				}
			}
		}
		
		if(winner >= 0) {
			System.out.println(winner + 1);
			return;
		}
		
		winner = 0;
		for(int i = 0; i < n; i++) {
			if(c[winner] == c[i] && r[winner] < r[i]) {
				winner = i;
			}
		}
		System.out.println(winner + 1);
	}		
}