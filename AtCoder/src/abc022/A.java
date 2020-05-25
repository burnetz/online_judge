package abc022;

import java.util.Scanner;

public class A {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s = sc.nextInt();
		int t = sc.nextInt();
		int w = sc.nextInt();

		int count = w >= s && w <= t ? 1: 0;

		for(int i = 0; i < n - 1; i++){
			w += sc.nextInt();
			count += w >= s && w <= t ? 1: 0;
		}

		System.out.println(count);
	}

}