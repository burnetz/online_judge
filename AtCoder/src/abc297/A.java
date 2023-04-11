package abc297;

import java.util.Scanner;

public class A {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int d = sc.nextInt();
		int t[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			t[i] = sc.nextInt();
			
			if(i >= 1 && t[i] - t[i - 1] <= d) {
				System.out.println(t[i]);
				return;
			}
		}
		
		System.out.println(-1);
	}		
}