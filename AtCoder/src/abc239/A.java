package abc239;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		double h = sc.nextDouble();
		
		System.out.println(Math.sqrt(h*(12800000 + h)));
	}
}
