package abc291;

import java.util.Scanner;

public class A {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if(c >= 'A' && c <= 'Z') {
				System.out.println(i + 1);
				return;
			}
		}
	}		
}