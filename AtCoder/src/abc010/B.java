package abc010;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		System.out.printf(str.substring(0, 1).toUpperCase() + str.substring(1, str.length()).toLowerCase());
	}
}