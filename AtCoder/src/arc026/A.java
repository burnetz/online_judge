package arc026;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();

		int result = 0;
		if(n <= 5){
			result = b*n;
		}
		else {
			result = b*5 + a*(n - 5);
		}
		System.out.println(result);
	}
}
