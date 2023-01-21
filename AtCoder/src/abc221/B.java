package abc221;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		String t = sc.next();
		
		if(s.equals(t)) {
			System.out.println("Yes");
			return;
		}
		for(int i = 0; i < s.length() - 1; i++) {
			String tmpStr = s.substring(0, i) + s.charAt(i + 1) + s.charAt(i) + s.substring(i + 2);
			
			if(tmpStr.equals(t)) {
				System.out.println("Yes");
				return;
			}
		}
		
		System.out.println("No");
	}
}

