package abc249;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		char[] str = sc.next().toCharArray();
		
		Arrays.sort(str);
		
		boolean large = false;
		boolean small = false;
		
		for(int i = 0; i < str.length; i++) {
			char c = str[i];
			
			if(i >= 1 && c == str[i - 1]) {
				System.out.println("No");
				return;
			}
			
			if(Character.isLowerCase(c)) {
				small = true;
			}
			else {
				large = true;
			}
		}
		
		if(small && large) {
			System.out.println("Yes");
		}
		
		else {
			System.out.println("No");
		}
	}
}