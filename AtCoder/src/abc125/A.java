package abc125;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int t = sc.nextInt();

		int cookies = 0;
		int next = a;

		while(next < t+0.5){
			cookies += b;
			next += a;
		}

		System.out.println(cookies);
	}

}
