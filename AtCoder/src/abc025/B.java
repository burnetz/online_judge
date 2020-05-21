package abc025;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();

		int pos = 0;
		for(int i = 0; i < n; i++){
			pos += (sc.next().equals("East") ? 1 : -1)*Math.min(b, Math.max(a, sc.nextInt()));
		}

		System.out.println(pos > 0 ? "East "+pos : (pos < 0 ? "West "+(-pos) : 0));
	}
}