package abc258;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		System.out.printf("%2d:%02d", n/60 + 21, n%60);
	}		
}

