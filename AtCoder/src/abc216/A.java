package abc216;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String str = sc.next();

		String[] strArray = str.split("\\.");
		
		int x = Integer.parseInt(strArray[0]);
		int y = Integer.parseInt(strArray[1]);
		
		if(y <= 2) {
			System.out.println(x+"-");
		}
		else if(y <= 6) {
			System.out.println(x);
		}
		else {
			System.out.println(x+"+");
		}
	}

}
