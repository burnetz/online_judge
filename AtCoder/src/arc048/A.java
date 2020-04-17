package arc048;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		
		long a = sc.nextInt();
		long b = sc.nextInt();
		
		if(a*b > 0) {
			System.out.println(b - a);	
		}
		else {
			System.out.println(b - a - 1);
		}
	}
}