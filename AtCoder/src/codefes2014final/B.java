package codefes2014final;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		int sum = 0;
		for(int i = 0; i < s.length(); i++) {
			sum += Math.pow(-1, i)*(s.charAt(i) - '0');
		}
		
		System.out.println(sum);
	}
}
