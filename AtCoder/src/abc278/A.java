package abc278;

import java.util.HashSet;
import java.util.Scanner;

public class A {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int a[] = new int[n + k];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		for(int i = k; i < n + k; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		
	}
}