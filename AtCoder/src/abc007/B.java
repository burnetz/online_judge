package abc007;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.next();

		System.out.println(str.equals("a") ? -1 : "a");
	}
}