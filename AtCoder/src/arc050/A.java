package arc050;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String str1 = sc.next();
		String str2 = sc.next();
		
		if(str1.toLowerCase().equals(str2)) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}
}