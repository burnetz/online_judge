package arc028;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();

		n %= (a + b);

		if(n != 0 && a >= n){
			System.out.println("Ant");
		}
		else {
			System.out.println("Bug");
		}
	}
}
