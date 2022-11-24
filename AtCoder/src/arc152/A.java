package arc152;

import java.util.Arrays;
import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int l = sc.nextInt();
		
		int a[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		int sum = 1;
		int tmp = -1;
		for(int i = 0; i < n && sum < l; i++) {
			sum += a[i] + 1;
			tmp = i;
		}
		
		for(int i = tmp + 1; i < n; i++) {
			if(a[i] == 2) {
				System.out.println("No");
				return;
			}
		}
		
		System.out.println("Yes");
		
	}
}