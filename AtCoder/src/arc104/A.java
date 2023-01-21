package arc104;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();

		int x = (a + b)/2;
		int y = (a - b)/2;

		System.out.println(x+" "+y);
	}
}