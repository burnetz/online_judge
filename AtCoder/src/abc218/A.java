package abc218;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String s = sc.next();

		if(s.charAt(n - 1) == 'o'){
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}

}
