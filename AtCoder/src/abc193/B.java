package abc193;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		int a[] = new int[n];
		int p[] = new int[n];
		int x[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			p[i] = sc.nextInt();
			x[i] = sc.nextInt();
		}
		
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++) {
			if(a[i] < x[i]) {
				min = Math.min(min, p[i]);
			}
		}
		
		System.out.println(min < Integer.MAX_VALUE ? min : -1);
	}

}
