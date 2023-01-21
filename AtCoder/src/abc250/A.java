package abc250;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		for(int i = 0; i < 3; i++) {
			str += str;
		}
		
		System.out.println(str.substring(0, 6));
	}		
}

