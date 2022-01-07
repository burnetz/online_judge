package abc229;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String str1 = sc.next();
		String str2 = sc.next();
		
		boolean result = false;
		if(str1.charAt(0) == '#') {
			if(str1.charAt(1) == '#' || str2.charAt(0) == '#') {
				result = true;
			}
		}
		if(str2.charAt(1) == '#') {
			if(str1.charAt(1) == '#' || str2.charAt(0) == '#') {
				result = true;
			}
		}
		
		System.out.println(result ? "Yes" : "No");
	}

}
