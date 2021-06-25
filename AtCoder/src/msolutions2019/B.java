package msolutions2019;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		
		int count = 15 - str.length();
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == 'o') {
				count++;
			}
		}
		
		System.out.println(count >= 8 ? "YES" : "NO");
	}

}
