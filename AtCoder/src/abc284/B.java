package abc284;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
 
		int t = sc.nextInt();
		
		for(int i = 0; i < t; i++) {
			int n = sc.nextInt();

			int odd = 0;
			
			for(int j = 0; j < n; j++) {
				if(sc.nextInt()%2 == 1) {
					odd++;
				}
			}
			
			System.out.println(odd);
		}		
	}
}
