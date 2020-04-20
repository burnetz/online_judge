package arc035;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		for(int i = 0; i < str.length()/2; i++) {
			char c1 = str.charAt(i);
			char c2 = str.charAt(str.length() - i - 1);

			if(c1 != '*' && c2 != '*' && c1 != c2){
				System.out.println("NO");
				return;
			}
		}

		System.out.println("YES");
	}
}