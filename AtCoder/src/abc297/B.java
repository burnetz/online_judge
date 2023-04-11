package abc297;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
 
		char[] str = sc.next().toCharArray();
		int b1 = 8;
		int b2 = 0;
		int r1 = 8;
		int r2 = 0;
		int k = 0;
		
		for(int i = 0; i < 8; i++) {
			if(str[i] == 'B') {
				b1 = Math.min(b1, i);
				b2 = Math.max(b2, i);
			}
			else if(str[i] == 'K') {
				k = i;
			}
			else if(str[i] == 'R') {
				r1 = Math.min(r1, i);
				r2 = Math.max(r2, i);
			}
		}
		
		if((b1 + b2) % 2 == 1 && r1 < k && r2 > k) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}		
}