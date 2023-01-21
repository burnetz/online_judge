package jsc2021;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int y = sc.nextInt();
		int z = sc.nextInt();
		
		for(int i = 1000000; i >= 0; i--) {
			if((double)y/x > (double)i/z) {
				System.out.println(i);
				return;
			}
		}
	}

}
