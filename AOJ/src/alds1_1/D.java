package alds1_1;

import java.util.Scanner;

public class D {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int a[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		int minArray[] = new int[n];
		int maxArray[] = new int[n];
		
		minArray[0] = a[0];
		maxArray[n - 1] = a[n - 1];
		for(int i = 1; i < n; i++) {
			minArray[i] = Math.min(a[i], minArray[i - 1]);
			maxArray[n - i] = Math.max(a[n - i], maxArray[n - i - 1]);
		}
		
		int result = maxArray[1] - minArray[0];
		for(int i = 1; i < n; i++) {
			result = Math.max(maxArray[i] - minArray[i - 1], result);
		}
		System.out.println(result);
	}
}
