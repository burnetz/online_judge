package abc280;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
 
		int n = sc.nextInt();
		
		int a[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			
			if(i == 0) {
				System.out.print(a[0] + " ");
			}
			else {
				System.out.print(a[i] - a[i - 1] + " ");
			}
		}
	}
}
