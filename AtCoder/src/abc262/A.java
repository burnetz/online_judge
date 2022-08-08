package abc262;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int y = sc.nextInt();
		
		System.out.println((4 - (y - 2) % 4)%4 + y);
	}		
}

