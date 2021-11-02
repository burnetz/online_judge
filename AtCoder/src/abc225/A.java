package abc225;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		
		if(s.charAt(0) == s.charAt(1) && s.charAt(1) == s.charAt(2)) {
			System.out.println(1);
		}
		else if((s.charAt(0) == s.charAt(1)) || (s.charAt(1) == s.charAt(2)) || (s.charAt(2) == s.charAt(0))) {
			System.out.println(3);
		}
		else {
			System.out.println(6);
		}
	}

}
