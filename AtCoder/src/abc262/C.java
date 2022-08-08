package abc262;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int correct = 0;
		int reverse = 0;
		
		int a[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		for(int i = 0; i < n; i++) {
			if(a[i] == i + 1) {
				correct++;
			}
			if(a[i] - 1 != i && a[a[i] - 1] == i + 1) {
//				System.out.println(a[i] - 1 + " and " + i);
				reverse++;
			}
		}
		reverse /= 2;
//		System.out.println(correct + " " + reverse);
		
		System.out.println((long)correct*(correct - 1)/2 + reverse);
	}
}