package abc277;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
 
		int n = sc.nextInt();
		String cards[] = new String[n];
		
		for(int i = 0; i < n; i++) {
			cards[i] = sc.next();
		}
		
		Arrays.sort(cards);
		
		for(int i = 0; i < n; i++) {
			if(i >= 1 && cards[i - 1].equals(cards[i])) {
				System.out.println("No");
				return;
			}
			
			char mark = cards[i].charAt(0);
			
			if(!(mark == 'S' || mark == 'H' || mark == 'C' || mark == 'D')) {
				System.out.println("No");
				return;
			}
			
			char num = cards[i].charAt(1);
			if(!((num >= '2' && num <= '9') || num == 'A' || num == 'T' || num == 'J' || num == 'Q' || num == 'K')) {
				System.out.println("No");
				return;
			}
		}
		
		System.out.println("Yes");
		
	}
}
