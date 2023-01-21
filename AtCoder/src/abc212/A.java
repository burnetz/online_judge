package abc212;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();

		System.out.println(b == 0 ? "Gold" :
			a == 0 ? "Silver" : "Alloy");
	}

}
