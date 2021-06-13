package abc187;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();

		int sa = 0;
		int sb = 0;

		for(int i = 0; i < 3; i++){
			sa += a % 10;
			sb += b % 10;

			a /= 10;
			b /= 10;
		}

		System.out.println(Math.max(sa, sb));
	}

}
