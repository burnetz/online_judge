package arc056;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		long a = sc.nextInt();
		long b = sc.nextInt();
		long k = sc.nextInt();
		long l = sc.nextInt();
		
		long result = Math.min((k/l)*b, (k/l)*l*a);
		result += Math.min((k%l)*a, b);
		
		System.out.println(result);
	}

}
