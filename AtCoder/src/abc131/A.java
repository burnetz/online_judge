package abc131;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		for(int i = 1; i < str.length(); i++) {
			if(str.charAt(i) == str.charAt(i - 1)) {
				System.out.println("Bad");
				return;
			}
		}
		
		System.out.println("Good");
	}

}
