package abc299;

import java.util.Scanner;

public class A {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String str = sc.next();
		
		String[] strArray = str.split("\\*", -1);
		
		if(strArray[0].contains("|") && strArray[1].contains("|")) {
			System.out.println("in");
		}
		else {
			System.out.println("out");
		}
	}		
}