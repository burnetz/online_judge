package abc108;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();
		int odd = (k + 1)/2;
		int even = k - odd;

		System.out.println(odd*even);
	}

}
