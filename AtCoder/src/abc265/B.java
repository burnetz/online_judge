package abc265;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
 
		int n = sc.nextInt();
		int m = sc.nextInt();
		long t = sc.nextLong();
		
		long cost[] = new long[n - 1];
		for(int i = 0; i < n - 1; i++) {
			cost[i] = sc.nextLong();
		}
		
		long bonus[] = new long[n];
		
		for(int i = 0; i < m ; i++) {
			int x = sc.nextInt() - 1;
			long y = sc.nextLong();
			
			bonus[x] = y;
		}
		
		for(int i = 1; i < n; i++) {
			t -= cost[i - 1];
			if(t <= 0) {
				System.out.println("No");
				return;
			}
			t += bonus[i];
		}
		
		System.out.println("Yes");
	}
}
 
	