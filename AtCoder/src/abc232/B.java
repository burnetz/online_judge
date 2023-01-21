package abc232;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String str1 = sc.next();
		String str2 = sc.next();
		
		if(str1.length() == 1) {
			System.out.println("Yes");
			return;
		}
		
		int diff = (26 + str2.charAt(0) - str1.charAt(0))%26;
		for(int i = 1; i < str1.length(); i++) {
			if((26 + str2.charAt(i) - str1.charAt(i))%26 != diff) {
				System.out.println("No");
				return;
			}
		}
		
		System.out.println("Yes");
	}
}

