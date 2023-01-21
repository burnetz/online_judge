package abc248;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		int sum = 0;
		for(int i = 0; i < str.length(); i++) {
			sum += str.charAt(i) - '0';
		}
		
		System.out.println(45 - sum);
	}		
}

