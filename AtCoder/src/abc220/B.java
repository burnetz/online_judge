package abc220;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();
		int a = Integer.parseInt(sc.next(), k);
		int b = Integer.parseInt(sc.next(), k);
		
		System.out.println((long)a*b);
	}
}

