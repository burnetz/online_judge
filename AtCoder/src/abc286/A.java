package abc286;

import java.util.Scanner;

public class A {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int p = sc.nextInt() - 1;
		int q = sc.nextInt() - 1;
		int r = sc.nextInt() - 1;
		int s = sc.nextInt() - 1;
		
		int a[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		for(int i = 0; i <= q - p; i++) {
			int tmp = a[p + i];
			a[p + i] = a[r + i];
			a[r + i] = tmp;
		}
		
		for(int i = 0; i < n; i++) {
			System.out.print(a[i] + " ");
		}
	}		
}