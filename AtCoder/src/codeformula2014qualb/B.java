package codeformula2014qualb;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		long sum = 0;
		
		for(int i = 1; i <= n; i++) {
			sum += sc.nextInt();
			
			if(sum >= k) {
				System.out.println(i);
				return;
			}
		}
	}

}
