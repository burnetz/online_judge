package abc105;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		System.out.println(n % k == 0 ? 0 : 1);
	}

}
