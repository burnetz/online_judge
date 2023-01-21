package abc267;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
 
		int colId[] = {3, 2, 4, 1, 3, 5, 0, 2, 4, 6};
		
		String s = sc.next();
		
		if(s.charAt(0) == '1') {
			System.out.println("No");
			return;
		}
		
		int count[] = new int[7];
		for(int i = 0; i < 10; i++) {
			count[colId[i]] += (int)(s.charAt(i) - '0');
		}
		
		for(int i = 0; i < 5; i++) {
			if(count[i] == 0) {
				continue;
			}
			
			boolean hasBlank = false;
			
			for(int j = i + 1; j < 7; j++) {
				if(count[j] == 0) {
					hasBlank = true;
				}
				
				if(count[j] > 0 && hasBlank) {
					System.out.println("Yes");
					return;
				}
			}
		}
		
		System.out.println("No");
	}
}
 
	