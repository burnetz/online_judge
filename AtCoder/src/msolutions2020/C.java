package msolutions2020;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int a[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		for(int i = k - 1; i < n - 1; i++) {
			if(a[i + 1] > a[i - k + 1]) {
				System.out.println("Yes");
			}
			else {
				System.out.println("No");
			}
		}
	}

}
