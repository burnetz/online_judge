package abc253;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		if((a <= b && b <= c) || (a >= b && b >= c) ) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}		
}

