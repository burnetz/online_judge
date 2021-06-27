package mujinpc2016;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		char c = sc.next().charAt(0);

		switch (c) {
		case 'O':
		case 'P':
		case 'K':
		case 'L':
			System.out.println("Right");
			break;

		default:
			System.out.println("Left");
			break;
		}
	}

}
