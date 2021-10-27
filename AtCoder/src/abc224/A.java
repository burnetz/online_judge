package abc224;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		
		if(s.matches("[a-z]*er")) {
			System.out.println("er");
		}
		else {
			System.out.println("ist");
		}
	}

}
