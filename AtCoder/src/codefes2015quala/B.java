package codefes2015quala;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		long sum = 0;
		for(int i = 0; i < n; i++) {
			sum += a[a.length - i - 1]*Math.pow(2, i);
		}
		
		System.out.println(sum);
	}

}
