package abc012;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.printf("%02d:%02d:%02d\n", n/3600, n%3600/60, n%60);
	}
}