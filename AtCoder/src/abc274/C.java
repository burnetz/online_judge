package abc274;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int a[] = new int[n*2 + 2];
		
		for(int i = 1; i <= n; i++) {
			int input = sc.nextInt();
			
			a[i*2] = a[i*2 + 1] = a[input] + 1;
		}
		
		for(int i = 1; i <= 2*n + 1; i++) {
			System.out.println(a[i]);
		}
	}
}

