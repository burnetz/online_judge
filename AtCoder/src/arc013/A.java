package arc013;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int l = sc.nextInt();
		int p = sc.nextInt();
		int q = sc.nextInt();
		int r = sc.nextInt();

		int result = 0;

		result = Math.max(result, (n/p) * (m/q) * (l/r));
		result = Math.max(result, (n/p) * (m/r) * (l/q));
		result = Math.max(result, (n/q) * (m/p) * (l/r));
		result = Math.max(result, (n/q) * (m/r) * (l/p));
		result = Math.max(result, (n/r) * (m/p) * (l/q));
		result = Math.max(result, (n/r) * (m/q) * (l/p));

		System.out.println(result);
	}
}
