package abc279;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
 
		String s = sc.next();
		String t = sc.next();
		
		if(s.contains(t)) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}
}
