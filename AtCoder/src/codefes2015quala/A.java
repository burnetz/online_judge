package codefes2015quala;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		char s[] = sc.next().toCharArray();

		s[s.length - 1]++;

		System.out.println(s);
	}

}
