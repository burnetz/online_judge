package arc116;

import java.util.Scanner;
import java.util.Vector;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		
		for(int i = 0; i < t; i++) {
			long n = sc.nextLong();
			
			if(n % 2 == 1) {
				System.out.println("Odd");
			}
			else if(n % 4 == 0) {
				System.out.println("Even");
			}
			else {
				System.out.println("Same");
			}
		}
	}
}