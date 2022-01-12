package abc234;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		
		System.out.println(func(func(func(x) + x) + func(func(x))));
	}
	
	static int func(int x) {
		return x*x + 2*x + 3;
	}

}
