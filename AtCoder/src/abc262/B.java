package abc262;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		int p[] = new int[n];
		int gen[] = new int[n];
		
		for(int i = 1; i < n; i++) {
			p[i] = sc.nextInt() - 1;
		}
		
		for(int i = 1; i < n; i++) {
			gen[i] = gen[p[i]] + 1;
		}
		
		System.out.println(gen[n - 1]);
	}
}

	
