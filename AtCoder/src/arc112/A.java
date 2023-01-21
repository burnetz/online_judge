package arc112;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for(int i = 0; i < t; i++){
			int l = sc.nextInt();
			int r = sc.nextInt();

			int n = Math.max(0, r - l*2 + 1);
			long count = (long)n*(n + 1)/2;

			System.out.println(count);
		}

	}
}