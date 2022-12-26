package abc283;

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
		
		int q = sc.nextInt();
		
		for(int i = 0; i < q; i++) {
			int mode = sc.nextInt();
			int k = sc.nextInt() - 1;
			
			if(mode == 1) {
				a[k] = sc.nextInt();
			}
			else {
				System.out.println(a[k]);
			}
		}
	}
}
