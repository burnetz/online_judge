package abc020;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str1 = sc.next();
		String str2 = sc.next();

		System.out.println(Integer.parseInt(str1 + str2) * 2);
	}
}