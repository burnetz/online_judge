package codeformula2014quala;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();

		for(int i = 1; i <= 100; i++) {
			if(i*i*i == a) {
				System.out.println("YES");
				return;
			}
		}
		
		System.out.println("NO");
	}

}
