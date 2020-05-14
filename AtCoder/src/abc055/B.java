package abc055;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		long power = 1;

		for(int i = 1; i <= n; i++){
			power *= i;
			power %= 1_000_000_007;
		}

		System.out.println(power);
    }
}