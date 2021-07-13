package arc106;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();

		long five = 5;
		for(int i = 1; i <= 26; i++) {
//			System.out.println(five);
			long three = 3;
			for(int j = 1; j <= 38; j++) {
				if(five + three == n) {
					System.out.println(j + " " + i);
					return;
				}
				three *= 3;
			}
			five *= 5;
		}
		System.out.println(-1);
	}
}