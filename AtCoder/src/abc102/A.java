package abc102;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		System.out.println(n % 2 == 0 ? n : 2*n);
	}

}
