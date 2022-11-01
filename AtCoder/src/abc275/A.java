package abc275;

import java.util.HashSet;
import java.util.Scanner;

public class A {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int a[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		int maxIndex = 0;
		int maxHeight = a[0];
		
		for(int i = 1; i < n; i++) {
			if(a[i] > maxHeight) {
				maxIndex = i;
				maxHeight = a[i];
			}
		}
		
		System.out.println(maxIndex + 1);
	}
}