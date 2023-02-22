package abc290;

import java.util.Scanner;

public class A {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int a[] = new int[n + 1];
		
		for(int i = 1; i <= n; i++) {
			a[i] = sc.nextInt();
		}
		
		int result = 0;
		
		for(int j = 0; j < m; j++) {
			result += a[sc.nextInt()];
		}
		
		System.out.println(result);
	}		
}