package arc009;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int result = 0;
		for(int i = 0; i < n; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();

			result += a*b;
		}

		System.out.println((int)(result*1.05));
	}
}
