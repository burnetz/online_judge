package abc006;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		System.out.println(sc.nextInt() % 3 == 0 ? "YES" : "NO");
	}

}