package abc093;

import java.util.Arrays;
import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		char str[] = sc.next().toCharArray();

		Arrays.sort(str);

		System.out.println(new String(str).equals("abc") ? "Yes" : "No");
	}

}
