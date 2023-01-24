package abc286;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
 
		int n = sc.nextInt();
		
		String str = sc.next();
		
		str = str.replace("na", "nya");
		
		System.out.println(str);
	}
}
