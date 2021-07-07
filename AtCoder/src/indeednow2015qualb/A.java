package indeednow2015qualb;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		
		if(x1 == x2) {
			System.out.println((int)Math.abs(y1 - y2) + 1);
		}
		else if(y1 == y2) {
			System.out.println((int)Math.abs(x1 - x2) + 1);
		}
		else {
			System.out.println((int)(Math.abs(y1 - y2) + Math.abs(x1 - x2) + 1));
		}
	}

}
