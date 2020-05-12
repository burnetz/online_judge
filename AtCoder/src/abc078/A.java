package abc078;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		char x = sc.next().charAt(0);
		char y = sc.next().charAt(0);

		System.out.println(x > y ? ">" :
			x < y ? "<" : "=");
	}

}
