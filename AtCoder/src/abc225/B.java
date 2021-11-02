package abc225;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		int appear[] = new int[n];
		for(int i = 0; i < n - 1; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			
			appear[a]++;
			appear[b]++;
		}

		for(int i = 0; i < n; i++) {
			if(appear[i] == n - 1) {
				System.out.println("Yes");
				return;
			}
		}
		
		System.out.println("No");
	}
}

