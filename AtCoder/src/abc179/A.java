package abc179;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String s = sc.next();

		if(s.charAt(s.length() - 1) == 's'){
			System.out.println(s + "es");
		}
		else {
			System.out.println(s + "s");
		}
	}

}
