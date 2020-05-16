package abc040;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int result = Integer.MAX_VALUE;
		for(int i = 1; i <= Math.sqrt(n); i++){
			result = Math.min(result, Math.abs(i - n/i) + (n - n/i*i));
		}

		System.out.println(result);
	}
}