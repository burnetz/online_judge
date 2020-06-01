package abc018;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		int n = sc.nextInt();

		for(int i = 0; i < n; i++) {
			int l = sc.nextInt() - 1;
			int r = sc.nextInt();
			
			str = str.substring(0, l) + new StringBuffer(str.substring(l, r)).reverse() + str.substring(r, str.length());
//			System.out.println(str);
		}
		
		System.out.println(str);
	}
}