package abc061;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int connect[] = new int[n];

		for(int i = 0; i < m; i++){
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;

			connect[a]++;
			connect[b]++;
		}

		for(int i = 0; i < n; i++){
			System.out.println(connect[i]);
		}
	}
}