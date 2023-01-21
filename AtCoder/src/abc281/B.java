package abc281;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
 
		String str = sc.next();

		if(str.length() != 8 || !Character.isAlphabetic(str.charAt(0)) || !Character.isAlphabetic(str.charAt(str.length() - 1))) {
			System.out.println("No");
			return;
		}
		String sub = str.substring(1, str.length() - 1);
		
		int num = 0;
		try {
			num = Integer.parseInt(sub);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("No");
			return;
		}
		
		if(num >= 100000) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}
}
