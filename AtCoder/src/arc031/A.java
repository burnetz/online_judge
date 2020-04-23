package arc031;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String str = sc.next();

		for(int i = 0; i < str.length()/2 ; i++){
			if(str.charAt(i) != str.charAt(str.length() - i - 1)){
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
}
