package abc268;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
 
		String s = sc.next();
		String t = sc.next();
		
		if(s.length() > t.length()){
			System.out.println("No");
			return;
		}
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) != t.charAt(i)) {
				System.out.println("No");
				return;
			}
		}
		
		System.out.println("Yes");
	}
}
 
	