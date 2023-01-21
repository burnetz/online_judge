package abc265;

import java.util.Scanner;

public class A {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int n = sc.nextInt();
		
		System.out.println(Math.min(n*x, (n/3)*y + n%3*x));
	}		
}