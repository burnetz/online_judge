package abc293;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
 
		int n = sc.nextInt();
		int a[] = new int[n];
		boolean called[] = new boolean[n];
		int count = n;
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt() - 1;
			if(!called[i] && !called[a[i]]) {
				called[a[i]] = true;
				count--;
			}
		}
		
		System.out.println(count);
		for(int i = 0; i < n; i++) {
			if(!called[i]) {
				System.out.print((i + 1) + " ");
			}
		}
	}		
}