package hhkb2020;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String t = sc.next();
		
		System.out.println(s.equals("Y") ? t.toUpperCase() : t);
	}

}
