package arc044;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		if(n == 2 || n == 3 || n == 5 || 
				(n >= 7 && n%2 != 0 && n%5 != 0 && n%3 != 0)) {
			System.out.println("Prime");
		}
		else {
			System.out.println("Not Prime");
		}
	}
}