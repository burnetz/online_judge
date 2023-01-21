package abc232;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		int x = str.charAt(0) - '0';
		int y = str.charAt(2) - '0';
		
		System.out.println(x*y);
	}

}
