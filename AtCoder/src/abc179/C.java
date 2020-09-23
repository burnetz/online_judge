package abc179;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		long sum = 0;

		for(int i = 1; i <= n - 1; i++){
			sum += (n - 1)/i;
		}

		System.out.println(sum);

	}
}