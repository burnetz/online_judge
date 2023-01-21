package abc240;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if(a == 1) {
			if(b == 2 || b == 10) {
				System.out.println("Yes");
			}
			else {
				System.out.println("No");
			}
		}
		else {
			if(a + 1 == b) {
				System.out.println("Yes");
			}
			else {
				System.out.println("No");
			}
		}
	}
}
