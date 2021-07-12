package abc209;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int x = sc.nextInt();
		
		int a[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		int sum = 0;
		
		for(int i = 0; i < n; i++) {
			if(i % 2 == 0) {
				sum += a[i];
			}
			else {
				sum += a[i] - 1;
			}
		}
		
		System.out.println(x >= sum ? "Yes" : "No");
	}
}
