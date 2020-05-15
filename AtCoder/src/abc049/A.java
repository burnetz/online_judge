package abc049;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		System.out.println("aeiou".contains(sc.next()) ? "vowel" : "consonant");
	}
}