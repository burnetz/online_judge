package abc005;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int result = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++) {
			result = Math.min(result, sc.nextInt());
		}

		System.out.println(result);
	}
}