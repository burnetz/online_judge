package abc033;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		char[] str = sc.next().toCharArray();

		System.out.println(str[0] == str[1] && str[1] == str[2] && str[2] == str[3] ? "SAME" : "DIFFERENT");
	}
}