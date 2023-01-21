package abc209;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();

		if(a > b) {
			System.out.println(0);
		}
		else {
			System.out.println(b - a + 1);
		}
	}

}
