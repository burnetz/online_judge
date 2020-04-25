package arc008;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		System.out.println(Math.min(n/10*100+n%10*15, (n + 9)/10*100));
	}
}
