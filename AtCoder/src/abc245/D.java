package abc245;

import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int a[] = new int[n + 1];
		int c[] = new int[n + m + 1];
		
		for(int i = 0; i <= n; i++) {
			a[n - i] = sc.nextInt();
		}
		
		for(int i = 0; i <= n + m; i++) {
			c[n + m - i] = sc.nextInt();
		}
		
		//筆算での除法を再現する。余りは生じないと仮定して良い。
		int b[] = new int[m + 1];
		for(int i = 0; i <= m; i++) {
			b[i] = c[i]/a[0];
			for(int j = 0; j <= n; j++) {
				c[i + j] -= a[j]*b[i];
			}
		}
		
		for(int i = 0; i <= m; i++) {
			System.out.print(b[m - i] + " ");
		}
		System.out.println();
	}
}
