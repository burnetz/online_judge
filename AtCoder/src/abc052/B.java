package abc052;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String str = sc.next();

		int max = 0;
		int x = 0;

		for(int i = 0; i < n; i++){
			x += str.charAt(i) == 'I' ? 1 : -1;
			max = Math.max(x, max);
		}
		System.out.println(max);

    }
}