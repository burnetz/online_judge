package abc154;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		String t = sc.next();
		int a = sc.nextInt();
		int b = sc.nextInt();
		String u = sc.next();
		
		if(s.equals(u)) {
			a--;
		}
		else {
			b--;
		}
		
		System.out.println(a+" "+b);
	}

}
